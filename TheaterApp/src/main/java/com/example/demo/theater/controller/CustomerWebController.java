package com.example.demo.theater.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerWebController {

    @GetMapping("/custInsert")
    public String insert() {
        return "/customer/custInsert";
    }

    @GetMapping("/custSelect")
    public String select() {
        return "/customer/custSelect";
    }

}
