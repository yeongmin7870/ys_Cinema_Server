package com.example.demo.theater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.theater.vo.PaymentList;

@Repository
public interface PaymentListRepository extends JpaRepository<PaymentList, Integer> {
}
