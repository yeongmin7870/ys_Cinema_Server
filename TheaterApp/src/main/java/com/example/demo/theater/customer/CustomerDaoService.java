package com.example.demo.theater.customer;

import oracle.sql.TIMESTAMP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerDaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerRepository repository;


    public List<Customer> findAll() {
        return repository.findAll();
    }


    public Customer findById(String customerId) {
        Customer customer = repository.findByCustomerId(customerId);
        return customer;
    }

    //    로그인 하기위한 메소드
    public String checkedCustomer(String id, String passwd, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Customer customer1 = repository.findByCustomerId(id);

        if (id.equals(customer1.getCustomerId()) && passwd.equals(customer1.getC_Pw())) {
            String SessionID = String.valueOf(System.currentTimeMillis()) + UUID.randomUUID().toString();
            session.setAttribute(SessionID, id);
            return SessionID;
        } else {
            return "fail";
        }

    }

    // 아이디 삭제
    public void deleteCustomer(String id) {
        repository.deleteById(id);
    }

    public Customer save(Customer customer) {
        repository.save(customer);
        return customer;
    }

    private String uploadFolderPath = "./serverImage/";

    public String uploadToLocal(String id, MultipartFile file) {
        try {
            Customer customer = repository.findByCustomerId(id);
            if (customer == null) {
                return "fail";
            }

            byte[] data = file.getBytes();
            String fileName = id + LocalDate.now() + LocalTime.now() + file.getOriginalFilename();
            Path path = Paths.get(uploadFolderPath + fileName);
            Files.write(path, data);
            // 여기까지는 이미지를 폴더에 저장함


            customer.setC_Profile(fileName);
            customer.setC_Profile_Path(path.toString());
            repository.save(customer);
            // 여기까지 디비에 이미지 이름과 경로 저장
            return "finish";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }


    public Customer updateCustomer(Customer newCustomer, String id) {
        Customer customer = repository.findByCustomerId(id);

        if (customer == null) {
            return null;
        }

        customer.setC_Pw(newCustomer.getC_Pw());
        customer.setC_Name(newCustomer.getC_Name());
        customer.setC_Nikname(newCustomer.getC_Nikname());
        customer.setC_Phone(newCustomer.getC_Phone());
        customer.setC_Total(newCustomer.getC_Total());
        customer.setC_Address(newCustomer.getC_Address());
        customer.setC_Point(newCustomer.getC_Point());
        customer.setC_Profile(newCustomer.getC_Profile());

        Customer updateCustomer = repository.save(customer);

        return updateCustomer;
    }
}
