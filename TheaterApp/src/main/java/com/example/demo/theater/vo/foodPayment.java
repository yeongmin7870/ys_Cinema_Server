package com.example.demo.theater.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class foodPayment {
    @Id
    @GeneratedValue
    private Integer fp_No;
    private String fp_Food;
    private Integer fp_Count;
    private Integer fp_Price;

}
