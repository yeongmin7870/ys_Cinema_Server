package com.example.demo.theater.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationDaoService {

    @Autowired
    private ReservationRepository repository;


    // 영화 예매하기 삽입
    public Reservation reserveMovie(Reservation reservation, String customerId) {
        Reservation newReservation = repository.save(reservation);
        return newReservation;
    }

}
