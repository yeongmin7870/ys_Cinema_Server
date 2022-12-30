package com.example.demo.theater.controller;

import com.example.demo.theater.customer.Customer;
import com.example.demo.theater.dao.CustomerDaoService;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
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
    @ApiOperation(value = "고객 토큰 해독")
    public String decodeToken(@RequestParam String token) {
        return service.decodeToken(token);
    }

    // 프로필 사진이라 고객이 이미지 업로드
    @PutMapping(value = "/customer/image/upload")
    @ApiOperation(value = "고객 프로필 사진 업로드 update")
    public String uploadLocal(@RequestParam String id, @RequestParam("file") MultipartFile multipartFile) {

        return service.uploadToLocal(id, multipartFile);
    }

    // 프로필 사진 이미지 보기
    @GetMapping("/customer/image/display")
    @ApiOperation(value = "고객 프로필 사진 보기")
    public ResponseEntity<Resource> getImage(@RequestParam String id) throws IOException {
        return service.getImage(id);
    }

    @GetMapping("/customers")
    @ApiOperation(value = "고객 정보 전부다 리스트로 가져오기")
    public List<Customer> retrieveAllCustomers() {

        return service.findAll();
    }

    @GetMapping("/customers/{customerId}")
    @ApiOperation(value = "한명의 고객 정보 가져오기")
    public Customer retrieveCustomers(@PathVariable String customerId) {
        Customer customer = service.findById(customerId);

        return customer;

    }

    @GetMapping("/customers/login")
    @ApiOperation(value = "로그인")
    public String checkedLogin(@RequestParam String id, String passwd, HttpServletRequest request) {
        String s = service.checkedCustomer(id, passwd, request);

        methodName = new Object() {
        }.getClass().getEnclosingMethod().getName(); // 메소드 명 가져오기

        logger.info(methodName + " 서비스를 실행하였고 " + "IP는 " + logController.clientIp(request));
        return s;
    }

    @GetMapping("/customers/session")
    @ApiOperation(value = "세션")
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
    @ApiOperation(value = "로그아웃", notes = "토큰은 유효시간이 지나면 사라지기 떄문에 그냥 서버쪽에서 저장하고 있던 토큰을 없애는 쪽으로 구현하길 바람")
    public String customerLogout(@RequestParam String id, HttpServletRequest request) {

        if (id.equals("")) {
            return "fail";
        } else {

            return "finish";
        }
    }

    // 회원가입
    @PostMapping("/customers")
    @ApiOperation(value = "회원가입")
    public ResponseEntity<Customer> newCustomers(@RequestBody Customer newCustomer) {
        Customer customer = service.findById(newCustomer.getCustomerId());

        if (customer == null) {
            service.save(newCustomer);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newCustomer.getCustomerId())
                    .toUri();
            return ResponseEntity.created(location).build();

        }

        return null;
    }

    @PutMapping("/customers/{id}")
    @ApiOperation(value = "고객정보 수정")
    public Customer replaceCustomers(@RequestBody Customer newCustomer,
            @PathVariable String id) {

        Customer updateCustomer = service.updateCustomer(newCustomer, id);

        return updateCustomer;
    }

    @DeleteMapping("/customers/{id}")
    @ApiOperation(value = "고객 삭제")
    public void deleteCustomers(@PathVariable String id) {
        service.deleteCustomer(id);
    }

}
