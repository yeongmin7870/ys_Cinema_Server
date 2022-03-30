package com.example.demo.theater.foodpayment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodPayment {
    @Id
    @GeneratedValue
    private Integer fp_No;
    @Column(columnDefinition = "varchar2(20)")
    private String fp_Food;
    private Integer fp_Count;
    private Integer fp_Price;

}
