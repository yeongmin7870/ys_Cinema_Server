package com.example.demo.theater.reservation;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class ReservationController {

    @Autowired
    private ReservationDaoService daoService;

    @PostMapping("reserve")
    @ApiOperation("영화예매하기 삽입 1. 회원   2. 비회원 ")
    public Reservation reserveMovie(@RequestBody Reservation reservation, @RequestParam String cId, @RequestParam String who) {
        Reservation result = null;
        if (who.equals("회원")) {
            result = daoService.reserveMovie(reservation, cId);
        } else if (who.equals("비회원")) {
            result = daoService.reserveMovie2(reservation, Integer.parseInt(cId));
        }
        return result;
    }

    @GetMapping("reserve")
    @ApiOperation("영화 예매한거 보여주기 1. 회원 2. 비회원")
    public List<Object> reserveOrderList(@RequestParam String who, @RequestParam String cId){
        List<Object> result = null;
        if (who.equals("회원")) {
            result = daoService.reserveOrderList(cId);
        } else if (who.equals("비회원")) {
            result = daoService.reserveOrderList2(Integer.parseInt(cId));
        }
        return result;
    }


}
