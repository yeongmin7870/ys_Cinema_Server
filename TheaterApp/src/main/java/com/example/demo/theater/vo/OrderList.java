package com.example.demo.theater.vo;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderList {
    @Id
    @GeneratedValue
    @Column(name = "orderId" , columnDefinition = "number", unique = true, nullable = false)
    private Integer orderId;
    @Column(name = "c_Id",columnDefinition = "VARCHAR2(10)")
    private String cId;
    private Integer fp_No;
    private Integer r_No;
}
