package com.example.demo.theater.paymentlist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentList {
    //사용안함
    @Id
    @GeneratedValue
    private Integer paymentL_No;

}
