package com.example.demo.theater.repository;

import com.example.demo.theater.vo.Customer;
import com.example.demo.theater.vo.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewCommentRepository extends JpaRepository<ReviewComment,Integer> {
}
