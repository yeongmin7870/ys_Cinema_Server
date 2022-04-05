package com.example.demo.theater.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDaoService {

    @Autowired
    private CustomerRepository repository;


    public List<Customer> findAll() {
        return repository.findAll();
    }


    public Optional<Customer> findById(Integer c_no) {
        return Optional.ofNullable(repository.findById(c_no)
                .orElseThrow(() -> new CustomerNotFoundException(c_no)));
    }

//    로그인 하기위한 메소드
    public String checkedCustomer(String id, String passwd) {
        Customer customer1 = repository.findByCustomerId(id);
        if (id.equals(customer1.getCustomerId()) && passwd.equals(customer1.getC_Pw())) {
            return "welcome";
        } else {
            return "fail";
        }

    }


    public String deleteById(Integer id) {
        repository.deleteById(id);
        return String.format("c_No : [%s] 계정이 삭제되었습니다.", id);
    }

    public Customer save(Customer customer) {
        repository.save(customer);
        return customer;
    }
}
