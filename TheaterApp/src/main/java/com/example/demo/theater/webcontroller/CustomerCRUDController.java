package com.example.demo.theater.webcontroller;

import com.example.demo.theater.customer.Customer;
import com.example.demo.theater.dao.CustomerDaoService;
import com.example.demo.theater.repository.CustomerRepository;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerCRUDController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerDaoService service;

    @GetMapping("/custInsert")
    @ApiOperation("회원정보등록 페이지")
    public String insert(Model model, @RequestParam(required = false) String customerId) {
        if (customerId == null) {
            model.addAttribute("customer", new Customer());
        } else {
            Customer customer = repository.findById(customerId).orElse(null);
            model.addAttribute("customer", customer);

        }

        return "customer/custInsert";
    }

    @PostMapping("/custInsert")
    @ApiOperation("회원정보등록")
    public RedirectView insertForm(@ModelAttribute Customer customer) {
        repository.save(customer);
        return new RedirectView("/customer/custSelect");
    }

    @GetMapping("/custSelect")
    @ApiOperation("회원정보검색 페이지")
    public String select(Model model) {
        List<Customer> customer = repository.findAll();
        ;
        model.addAttribute("customer", customer);
        logger.info("select page");
        service.tests();
        return "customer/custSelect";
    }
    //

}
