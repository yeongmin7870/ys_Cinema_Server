package com.example.demo.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.theater.vo.SpecialTheater;

public interface SpecialTheaterRepository extends JpaRepository<SpecialTheater, Integer> {
}
