package com.example.demo.theater.reviewcomment;

import com.example.demo.theater.moviereview.MovieReview;
import com.example.demo.theater.reviewcomment.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewCommentRepository extends JpaRepository<ReviewComment,Integer> {

    @Query(value = "SELECT m FROM ReviewComment m WHERE m.rcId = :rcId AND m.mrNo = :mrNo")
    ReviewComment retrieveComments(@Param("rcId") Integer rcId, @Param("mrNo") Integer mrNo);
}
