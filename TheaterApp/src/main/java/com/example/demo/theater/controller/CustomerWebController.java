package com.example.demo.theater.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerWebController {

    @GetMapping("/custInsert")
    @ApiOperation("회원정보등록 페이지")
    public String insert() {
        return "/customer/custInsert";
    }

    @GetMapping("/custSelect")
    @ApiOperation("회원정보검색 페이지")
    public String select() {
        return "/customer/custSelect";
    }

}
