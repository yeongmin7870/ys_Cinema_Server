package com.example.demo.theater.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.theater.dao.NonCustomerDaoService;
import com.example.demo.theater.vo.NonCustomer;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class NonCustomerController {

    @Autowired
    private NonCustomerDaoService service;

    @PostMapping("/nonCustomer")
    @ApiOperation(value = "비회원 회원가입", notes = "이름, 핸드폰만")
    String registerNonCustomer(@RequestBody NonCustomer nonCustomer) {
        return service.registerNonCustomer(nonCustomer);
    }

    @GetMapping("/nonCustomer")
    @ApiOperation("전체 비회원 리스트확인")
    List<NonCustomer> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/nonCustomer/{id}")
    @ApiOperation("비회원 삭제")
    void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }

    @GetMapping("/nonCustomer/{ncPhone}")
    @ApiOperation("핸드폰 번호로 한명의 정보 가져오기")
    NonCustomer retrieveCustomer(@PathVariable String ncPhone) {
        return service.retrieveCustomer(ncPhone);
    }

    @GetMapping("/nonCustomer/login")
    @ApiOperation("로그인")
    String loginNonCustomer(@RequestParam String name, String phone) {
        return service.loginNonCustomer(name, phone);
    }

    @GetMapping("/nonCustomer/parser")
    @ApiOperation("토큰 해독")
    String decodeToken(@RequestParam String token) {
        return service.decodeToken(token);
    }
}
