package com.example.demo.theater.repository;

import com.example.demo.theater.vo.MovieReview;
import com.example.demo.theater.vo.ReviewComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Integer> {

    @Query(value = "SELECT m FROM ReviewComment m WHERE m.reviewCommentId = :reviewCommentId AND m.mrNo = :mrNo")
    ReviewComment retrieveComments(@Param("reviewCommentId") Integer reviewCommentId, @Param("mrNo") Integer mrNo);
}
