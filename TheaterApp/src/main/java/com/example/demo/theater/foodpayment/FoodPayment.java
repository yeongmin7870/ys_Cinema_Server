package com.example.demo.theater.foodpayment;

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
public class FoodPayment {
    @Id
    @GeneratedValue
    @Column(name = "fp_No", columnDefinition = "number")
    private Integer foodPaymentId;
    @Column(columnDefinition = "varchar2(20)")
    private String fp_Food;
    @Column(columnDefinition = "number")
    private Integer fp_Count;
    @Column(columnDefinition = "number")
    private Integer fp_Price;

}
