package com.example.demo.theater.customer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/theater")
@CrossOrigin
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private CustomerDaoService service;



    @PostMapping("/customer/image/upload")
    public String uploadLocal(@RequestParam String id,@RequestParam("file")MultipartFile multipartFile){
        return service.uploadToLocal(id,multipartFile);
    }


    @GetMapping("/customers")
    public List<Customer> retrieveAllCustomers() {
        return service.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer retrieveCustomers(@PathVariable String customerId) {
        Customer customer = service.findById(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException(String.format("ID [%s] not found", customerId));
        }

        return customer;

    }

    @GetMapping("/customers/login")
    public String checkedLogin(@RequestParam String id, String passwd, HttpServletRequest request) {
        return service.checkedCustomer(id, passwd, request);
    }

    @GetMapping("/customers/session")
    public String createSession(@RequestParam String id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (!id.equals("")) {
            String result = session.getAttribute(id).toString();
            logger.info(result);
            return result;
        } else {
            return "fail";
        }
    }

    @GetMapping("/customers/logout")
    public String customerLogout(@RequestParam String id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (id.equals("")) {
            return "fail";
        } else {
            String result = session.getAttribute(id).toString();
            session.removeAttribute(result);
            return "finish";
        }
    }


    // 회원가입
    @PostMapping("/customers")
    public ResponseEntity<Customer> newCustomers(@RequestBody Customer newCustomer) {
        Customer customer = service.findById(newCustomer.getCustomerId());


        if (customer == null) {
            service.save(newCustomer);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newCustomer.getCustomerId())
                    .toUri();
            return ResponseEntity.created(location).build();

        } else {
            throw new CustomerNotFoundException(String.format("ID [%s] already exist", customer.getCustomerId()));
        }
    }


    @PutMapping("/customers/{id}")
    public Customer replaceCustomers(@RequestBody Customer newCustomer,
                                     @PathVariable String id) {

        Customer updateCustomer = service.updateCustomer(newCustomer, id);
        if (updateCustomer == null) {
            throw new CustomerNotFoundException(String.format("ID [%s] Not Found ", id));
        }

        return updateCustomer;
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomers(@PathVariable String id) {
        service.deleteCustomer(id);
    }


}
