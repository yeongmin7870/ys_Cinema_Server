package com.example.demo.theater.nonCustomer;

import com.example.demo.theater.customer.CustomerDaoService;
import com.example.demo.theater.exception.CustomizeResponseEntityExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NonCustomerDaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NonCustomerRepository nonCustomerRepository;


    //비회원 가입
    String registerNonCustomer(NonCustomer newCustomer) {

        NonCustomer nonCustomer = nonCustomerRepository.retrieveNonCustomer(newCustomer.getNcPhone());

        if (nonCustomer == null) {
            nonCustomerRepository.save(newCustomer);
            return "finish";
        } else {
            return "fail";
        }

    }

    //전체리스트 보기
    List<NonCustomer> findAll(){
        return nonCustomerRepository.findAll();
    }

    // 비회원 수정
    void deleteCustomer(Integer id){
        nonCustomerRepository.deleteById(id);
    }

    // 핸드폰 번호로 한명 검색하기
    NonCustomer retrieveCustomer (String ncPhone){
        return nonCustomerRepository.retrieveNonCustomer(ncPhone);
    }


    //로그인

    String loginNonCustomer(String name, String phone){
        NonCustomer nonCustomer = nonCustomerRepository.retrieveNonCustomer(phone);
        logger.info(nonCustomer.toString());
        if(nonCustomer.getNc_Name().equals(name)){
            String token = CustomerDaoService.makeJwtToken(name, phone);
            return token;
        }else{
            return "fail";
        }

    }
}
