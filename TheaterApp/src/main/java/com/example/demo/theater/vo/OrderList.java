package com.example.demo.theater.vo;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class OrderList {
    @Id
    @GeneratedValue
    @Column(name = "orderId", columnDefinition = "number", unique = true, nullable = false)
    private Integer orderId;
    @Column(name = "c_Id", columnDefinition = "VARCHAR2(10)")
    private String cId;
    private Integer fp_No;
    private Integer r_No;
}
