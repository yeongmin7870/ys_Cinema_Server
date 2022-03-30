package com.example.demo.theater.reviewgrade;

import com.example.demo.theater.reviewgrade.ReviewGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewGradeRepository extends JpaRepository<ReviewGrade,Integer> {
}
