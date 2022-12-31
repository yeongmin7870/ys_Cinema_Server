package com.example.demo.theater.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PaymentList {
    // 사용안함
    @Id
    @GeneratedValue
    private Integer paymentL_No;

}
