package com.example.demo.theater.moviereview;

import com.example.demo.theater.writedReview.WritedReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {

    MovieReview findByMovieReviewId(Integer id);


    @Query(value = "SELECT SUM(mrReviewStarScore) FROM MovieReview WHERE movieId = :movieId")
    Integer sumRating(@Param("movieId") Integer movieId);  // 평점 합계


    List<MovieReview> findByMovieId(Integer movieId); // 영화아이디로 리뷰 찾기

    @Query(value = "SELECT w FROM WritedReview w Where w.customerId = :customerId")
    WritedReview oneReview(@Param("customerId") String customerId);    // 리뷰 쓴적 있는지 판단


    @Query(value = "SELECT m FROM MovieReview m Where m.movieReviewId = :movieReviewId")
    MovieReview retrieveReview(@Param("movieReviewId") Integer movieReviewId);


}
