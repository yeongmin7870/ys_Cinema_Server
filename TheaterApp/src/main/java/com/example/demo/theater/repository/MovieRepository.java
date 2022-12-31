package com.example.demo.theater.repository;

import com.example.demo.theater.vo.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findByMovieId(Integer id);

    @Query("SELECT MAX(movieId) FROM Movie")
    Integer findMovieIdMax();

    @Query(value = "SELECT sum(m_Rating) FROM Movie")
    public Integer sumRating();  // 평저 합계
    //매개변수가 없는 메소드임...

}