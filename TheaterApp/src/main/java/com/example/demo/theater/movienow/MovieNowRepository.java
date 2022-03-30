package com.example.demo.theater.movienow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieNowRepository extends JpaRepository<MovieNow,Integer> {
}
