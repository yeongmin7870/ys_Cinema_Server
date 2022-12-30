package com.example.demo.theater.repository;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.theater.vo.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
