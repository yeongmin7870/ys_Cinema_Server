package com.example.demo.theater.normalSeat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalSeatRepository extends JpaRepository<NormalSeat,String> {

    NormalSeat findByNormalSeatId(String id);

}
