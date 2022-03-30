package com.example.demo.theater.reviewcomment;

import com.example.demo.theater.reviewcomment.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewCommentRepository extends JpaRepository<ReviewComment,Integer> {
}
