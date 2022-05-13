package com.example.demo.theater.customer;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.hibernate.annotations.Parameter;
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
import javax.xml.bind.DatatypeConverter;

import java.io.IOException;
import java.net.URI;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/theater")
@CrossOrigin
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String secretKey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoaSJ9.GY_JamNllFTbrZ1qd2LVM1CcKp45bHKYFnHkWELr__U";


    @Autowired
    private CustomerDaoService service;

    // 토큰 생성
    @GetMapping("/customer/token/generate/{id}")
    public String makeJwtToken(@PathVariable String id) {

        Customer customer = service.findById(id);
        if (customer == null) {
            return "fail";
        } else {
            Date ext = new Date();

            Long expiredTime = 1000 * 60L *60L *2L; //2시간
            ext.setTime(ext.getTime() + expiredTime);

            Claims claims = Jwts.claims()
                    .setSubject("hi")
                    .setIssuedAt(new Date())
                    .setExpiration(ext);
            claims.put("hi", "123");

            String jwt = Jwts.builder()
                    .setHeaderParam("typ", "JWT")
                    .setClaims(claims)
                    .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                    .compact();

            return jwt;
        }
    }

    @GetMapping("/customer/token/parser")
    public boolean decodeToken(@RequestParam String jwt ) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .parseClaimsJws(jwt).getBody();
            logger.info(claims.toString());
            return true;
        } catch (ExpiredJwtException e) {
            logger.error("Token Expired");
            return false;
        } catch (JwtException e) {
            logger.error("Token Error");
            return false;
        }

    }


    @PutMapping("/customer/image/upload")
    public String uploadLocal(@RequestParam String id, @RequestParam("file") MultipartFile multipartFile) {
        return service.uploadToLocal(id, multipartFile);
    }


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
