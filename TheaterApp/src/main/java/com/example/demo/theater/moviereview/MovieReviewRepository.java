package com.example.demo.theater.moviereview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {

    MovieReview findByMovieReviewId(Integer id);


//    @Query(value = "SELECT * FROM Movie m, MovieReview mr WHERE ")
//    MovieReview sumRating();  // 평저 합계
}
