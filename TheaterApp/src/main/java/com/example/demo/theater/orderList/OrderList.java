package com.example.demo.theater.orderList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderList {
    @Id
    @Column(columnDefinition = "VARCHAR2(10)")
    private Integer c_Id;
    private Integer fp_No;
    private Integer r_No;
}
