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


    /*//해당 영화의 종료시간 연산
    @Transactional
    @Modifying
    @Query(value = "UPDATE Movie_Schedule ms " +
            "SET ms.mS_End_Time = to_char(ms.mS_Star_Time + (interval ':m_Hour' MINUTE),'YYYY-MM-DD-HH24:MI:SS')" +
            "WHERE ms.ms_no = :movieScheduleId", nativeQuery = true)
    void endTime(@Param("m_Hour") Integer m_Hour,@Param("movieScheduleId") Integer movieScheduleId);
    //여기까지 했음*/

    /*numToDSInterval(*/

    @Transactional
    @Modifying
    @Query (value = "insert into movie_schedule ms\n" +
            "(ms.MS_NO, ms.MS_END_TIME, ms.MS_STAR_TIME, ms.M_NO, ms.STORE_NO)\n" +
            "VALUES\n" +
            "(movie_schedule_seq.NEXTVAL," +
            ":ms_StarTime + (interval '1' minute) * :m_Hour," +
            ":ms_StarTime," +
            ":m_no," +
            ":store_No)", nativeQuery = true)
    void insertSchedule (@Param("ms_StarTime") Date m_StarTime,
                         @Param("m_no") Integer m_no,
                         @Param("store_No") Integer store_No,
                         @Param("m_Hour") Integer m_Hour);

    @Transactional
    @Modifying
    @Query (value = "update movie_schedule ms" +
            "set ms.MS_END_TIME = :ms_StarTime + (interval '1' minute) * :m_Hour," +
            "ms.MS_STAR_TIME = :ms_StarTime," +
            "ms.M_NO = :m_no," +
            "ms.STORE_NO = :store_No" +
            "WHERE ms.MS_NO = :ms_No",nativeQuery = true)
    void updateSchedule (@Param("ms_StarTime") Date ms_StarTime,
                         @Param("m_no") Integer m_no,
                         @Param("store_No") Integer store_No,
                         @Param("m_Hour") Integer m_Hour,
                         @Param("ms_No") Integer ms_No);
}
