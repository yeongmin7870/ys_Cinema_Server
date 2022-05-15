package com.example.demo.theater.customer;


import com.example.demo.logControll.LogController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/theater")
@CrossOrigin
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String methodName;

    private LogController logController;

    @Autowired
    private CustomerDaoService service;


    @GetMapping("/customer/token/parser")
    public String decodeToken(@RequestParam String token) {
        return service.decodeToken(token);
    }

    //프로필 사진이라 고객이 이미지 업로드
    @PutMapping("/customer/image/upload")
    public String uploadLocal(@RequestParam String id, @RequestParam("file") MultipartFile multipartFile) {
        return service.uploadToLocal(id, multipartFile);
    }

    //프로필 사진 이미지 보기
    @GetMapping("/customer/image/display")
    public ResponseEntity<Resource> getImage(@RequestParam String id) throws IOException {
        return service.getImage(id);
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
        String s = service.checkedCustomer(id, passwd, request);

        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName(); //메소드 명 가져오기

        logger.info(methodName + " 서비스를 실행하였고 " + "IP는 " + logController.clientIp(request));
        return s;
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
