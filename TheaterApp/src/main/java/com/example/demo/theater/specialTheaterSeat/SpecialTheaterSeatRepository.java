package com.example.demo.theater.specialTheaterSeat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialTheaterSeatRepository extends JpaRepository<SpecialTheaterSeat, String> {
}
