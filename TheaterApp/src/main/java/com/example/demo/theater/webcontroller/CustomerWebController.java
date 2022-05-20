package com.example.demo.theater.webcontroller;


import com.example.demo.theater.customer.Customer;
import com.example.demo.theater.customer.CustomerDaoService;
import com.example.demo.theater.customer.CustomerNotFoundException;
import com.example.demo.theater.customer.CustomerRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerWebController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/custInsert")
    @ApiOperation("회원정보등록 페이지")
    public String insert() {
        return "/customer/custInsert";
    }

    @GetMapping("/custSelect")
    @ApiOperation("회원정보검색 페이지")
    public String select(Model model) {
        List<Customer> customer = repository.findAll();;
        model.addAttribute("customer", customer);

        return "/customer/custSelect";
    }

    @GetMapping("/custUpdate")
    @ApiOperation("회원정보수정 페이지")
    public String update() {
        return "/customer/custUpdate";
    }
}
