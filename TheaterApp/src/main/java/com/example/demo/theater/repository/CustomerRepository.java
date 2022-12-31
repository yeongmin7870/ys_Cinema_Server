package com.example.demo.theater.repository;

import com.example.demo.theater.vo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByCustomerId(String id);

}
