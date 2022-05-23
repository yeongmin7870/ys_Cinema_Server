package com.example.demo.theater.orderList;

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
    @Column(name = "c_Id",columnDefinition = "VARCHAR2(10)")
    private String cId;
    private Integer fp_No;
    private Integer r_No;
}
