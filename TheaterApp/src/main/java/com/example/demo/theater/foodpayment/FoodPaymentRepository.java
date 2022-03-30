package com.example.demo.theater.foodpayment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPaymentRepository extends JpaRepository<FoodPayment,Integer> {
}
