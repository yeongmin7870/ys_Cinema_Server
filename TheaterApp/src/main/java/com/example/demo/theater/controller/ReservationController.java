package com.example.demo.theater.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.theater.dao.ReservationDaoService;
import com.example.demo.theater.vo.Reservation;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class ReservationController {

    @Autowired
    private ReservationDaoService daoService;

    @PostMapping("reserve")
    @ApiOperation(value = "영화예매하기 삽입 1. 회원   2. 비회원 ", notes = "m_No : 영화 id " +
            "msNo : 상영시간표 id " +
            "r_TotalPrice : 총액 "+
            "normalScreenId : 상영관 아이디" +
            " normalSeatId : 좌석 아이디")
    public ResponseEntity reserveMovie(@RequestBody Reservation reservation, @RequestParam String cId, @RequestParam String who) {

        if (who.equals("회원")) {
           daoService.reserveMovie(reservation, cId);
        } else if (who.equals("비회원")) {
            daoService.reserveMovie2(reservation, Integer.parseInt(cId));
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("reserve")
    @ApiOperation(value = "영화 예매한거 보여주기 1. 회원 2. 비회원" , notes = "쓸만한 값만 가져가도 됨" +
            "m_No : 영화번호 " +
            "mS_No : 상영시간표넘버 " +
            "normal_SID : 상영관과 좌석 " +
            "r_Date : 예매일 "
        )
    public List<Reservation> reserveOrderList(@RequestParam String who, @RequestParam String cId){
        List<Reservation> result = null;
        if (who.equals("회원")) {
            result = daoService.reserveOrderList(cId);
        } else if (who.equals("비회원")) {
            result = daoService.reserveOrderList2(Integer.parseInt(cId));
        }
        return result;
    }


}
