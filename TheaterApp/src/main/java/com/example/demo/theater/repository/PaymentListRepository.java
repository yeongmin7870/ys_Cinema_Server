package com.example.demo.theater.repository;

import com.example.demo.theater.vo.PaymentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PaymentListRepository extends JpaRepository<PaymentList, Integer> {
}
