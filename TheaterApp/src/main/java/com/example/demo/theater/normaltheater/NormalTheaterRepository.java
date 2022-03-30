package com.example.demo.theater.normaltheater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalTheaterRepository extends JpaRepository<NormalTheater,Integer> {
}
