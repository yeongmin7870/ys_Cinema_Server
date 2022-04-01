package com.example.demo.theater.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Integer No;
    private  Integer food_No;
    private Integer c_No;
    @Column(columnDefinition = "varchar2(7)")
    private String c_total;
}
