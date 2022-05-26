package com.example.demo.theater.normaltheaterseat;

import com.example.demo.theater.normaltheater.NormalTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalTheaterSeatRepository extends JpaRepository<NormalTheater,String> {
}