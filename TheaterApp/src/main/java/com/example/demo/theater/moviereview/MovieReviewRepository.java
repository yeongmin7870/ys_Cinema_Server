package com.example.demo.theater.moviereview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {

    MovieReview findByMovieReviewId(Integer id);


    @Query(value = "SELECT SUM(mr_ReviewStarScore) FROM MovieReview WHERE movieId = :movieId")
    Integer sumRating(@Param("movieId") Integer movieId);  // 평점 합계


    List<MovieReview> findByMovieId(Integer movieId); // 영화아이디로 리뷰 찾기

    @Query(value = "SELECT m FROM MovieReview m WHERE m.cId = :cId AND m.movieId = :movieId")
    MovieReview oneReview(@Param("cId") String cId, @Param("movieId") Integer movieId);
}
