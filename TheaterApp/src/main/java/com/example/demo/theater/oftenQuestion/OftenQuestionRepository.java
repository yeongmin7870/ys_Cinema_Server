package com.example.demo.theater.oftenQuestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OftenQuestionRepository extends JpaRepository<OftenQuestion, Integer> {

}
