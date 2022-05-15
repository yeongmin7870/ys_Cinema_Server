package com.example.demo.theater.movieSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface movieScheduleRepository extends JpaRepository<MovieSchedule, Integer> {
    
}
