package com.example.demo.theater.normaltheaterseat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalTheaterSeatRepository extends JpaRepository<NormalTheaterSeat,Integer> {
}
