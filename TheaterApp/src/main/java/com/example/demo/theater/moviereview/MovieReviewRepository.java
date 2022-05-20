package com.example.demo.theater.moviereview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {

    MovieReview findByMovieReviewId(Integer id);


    @Query(value = "SELECT SUM(mr_ReviewStarScore) FROM MovieReview WHERE m_No = :mno")
    Integer sumRating(@Param("mno") Integer mno);  // 평점 합계


    MovieReview findByMno(Integer m_No);
}
