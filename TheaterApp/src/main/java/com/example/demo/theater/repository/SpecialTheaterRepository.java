package com.example.demo.theater.repository;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.theater.vo.SpecialTheater;

public interface SpecialTheaterRepository extends JpaRepository<SpecialTheater, Integer> {
}
