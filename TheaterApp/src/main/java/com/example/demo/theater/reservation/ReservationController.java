package com.example.demo.theater.reservation;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class ReservationController {

    @Autowired
    private ReservationDaoService daoService;

    @PostMapping("/theater/reserve/{customerId}")
    @ApiOperation("영화예매하기 삽입")
    public Reservation reserveMovie(@RequestBody Reservation reservation, @PathVariable String customerId){
        return daoService.reserveMovie(reservation,customerId);
    }
}
