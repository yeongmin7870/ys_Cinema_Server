package com.example.demo.theater.controller;


import com.example.demo.theater.customer.Customer;
import com.example.demo.theater.customer.CustomerDaoService;
import com.example.demo.theater.customer.CustomerNotFoundException;
import com.example.demo.theater.customer.CustomerRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/customer")
public class CustomerWebController {

    @Autowired
    private CustomerDaoService service;

    @GetMapping("/custInsert")
    @ApiOperation("회원정보등록 페이지")
    public String insert(@RequestBody Customer newCustomer) {
        Customer customer = service.findById(newCustomer.getCustomerId());

        return "/customer/custInsert";
    }

    @GetMapping("/custSelect")
    @ApiOperation("회원정보검색 페이지")
    public String select() {
        return "/customer/custSelect";
    }

    @GetMapping("/custUpdate")
    @ApiOperation("회원정보수정 페이지")
    public String update() {
        return "/customer/custUpdate";
    }
}
