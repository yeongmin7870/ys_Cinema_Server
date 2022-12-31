package com.example.demo.theater.repository;

import com.example.demo.theater.vo.NormalSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalSeatRepository extends JpaRepository<NormalSeat,Integer> {

    @Query("SELECT n FROM NormalSeat n WHERE normalSeatId = :normalSeatId")
    NormalSeat findNormalSeatId(@Param("normalSeatId") String normalSeatId);

    @Query("SELECT max(n) FROM NormalSeat n")
    Integer findNormalMax();
}
