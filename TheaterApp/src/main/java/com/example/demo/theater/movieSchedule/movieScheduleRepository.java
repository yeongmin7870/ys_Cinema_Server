package com.example.demo.theater.movieSchedule;

import com.example.demo.theater.movie.Movie;
import com.example.demo.theater.storeaddress.StoreAddress;
import oracle.sql.DATE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface movieScheduleRepository extends JpaRepository<MovieSchedule, Integer> {
    MovieSchedule findByMovieScheduleId(Integer id);

    //해당 점포, 영화가 있고 해당 영화가 현재 상영중인가를 따짐
    @Query(value = "select mv, st from Movie mv,StoreAddress st where st.storeId = :storeId and mv.movieId = :mNo and mv.m_EndDate >= :serverTime")
    List<Object> DataCheck(@Param("storeId") Integer storeId, @Param("mNo") Integer mNo, @Param("serverTime")Date serverTime);

    //해당 영화의 상영시간을 뽑아오는 쿼리
    @Query(value = "select mv.m_Hour from Movie mv where mv.movieId = :movieId")
    String movieHour(@Param("movieId") Integer movieId);


    //해당 영화의 종료시간 연산
    @Transactional
    @Modifying
    @Query(value = "UPDATE MovieSchedule ms SET ms.mS_EndTime = ms.mS_StarTime + interval ':m_Hour' minute where movieScheduleId = :movieScheduleId", nativeQuery = true)
    void endTime(@Param("m_Hour") Integer m_Hour,@Param("movieScheduleId") Integer movieScheduleId);


}
