package com.example.demo.theater.dao;

import com.example.demo.theater.exception.CustomizeResponseEntityExceptionHandler;
import com.example.demo.theater.repository.FoodPaymentRepository;
import com.example.demo.theater.repository.NonCustomerRepository;
import com.example.demo.theater.repository.ReservationRepository;
import com.example.demo.theater.vo.NonCustomer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NonCustomerDaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NonCustomerRepository nonCustomerRepository;
    @Autowired
    private FoodPaymentRepository foodPaymentRepository;

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerDaoService customerDaoService;

    // 비회원 가입
    String registerNonCustomer(NonCustomer newCustomer) {

        NonCustomer nonCustomer = nonCustomerRepository.retrieveNonCustomer(newCustomer.getNcPhone());
        System.out.println(nonCustomer);

        if (nonCustomer == null) {
            newCustomer.setC_Profile_Path("./src/main/resources/serverImage/profile/");
            newCustomer.setC_Profile("profile.png");
            nonCustomerRepository.save(newCustomer);
            return "finish";
        } else {
            return "fail";
        }

    }

    // 전체리스트 보기
    List<NonCustomer> findAll() {
        return nonCustomerRepository.findAll();
    }

    // 비회원 수정
    void deleteCustomer(Integer id) {
        nonCustomerRepository.deleteById(id);
    }

    // 핸드폰 번호로 한명 검색하기
    NonCustomer retrieveCustomer(String ncPhone) {
        return nonCustomerRepository.retrieveNonCustomer(ncPhone);
    }

    // 로그인
    String loginNonCustomer(String name, String phone) {
        NonCustomer nonCustomer = nonCustomerRepository.retrieveNonCustomer(phone);
        logger.info(nonCustomer.toString());
        if (nonCustomer.getNc_Name().equals(name)) {
            String token = CustomerDaoService.makeJwtToken(name, phone);
            return token;
        } else {
            return "fail";
        }
    }

    // 토큰 해독

    String decodeToken(String token) {
        return customerDaoService.decodeToken(token);
    }
}
