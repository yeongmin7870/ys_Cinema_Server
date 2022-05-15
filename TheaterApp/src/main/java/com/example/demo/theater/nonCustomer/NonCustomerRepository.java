package com.example.demo.theater.nonCustomer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NonCustomerRepository extends JpaRepository<NonCustomer, Integer> {

}
