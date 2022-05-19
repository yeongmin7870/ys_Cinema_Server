package com.example.demo.theater.foodpayment;

import com.sun.istack.NotNull;
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
    @NotNull
    @Column(name = "fp_No", columnDefinition = "number",unique = true)
    private Integer foodPaymentId;
    @Column(columnDefinition = "number")
    private Integer food_No;
    @Column(columnDefinition = "number")
    private Integer fp_Count;
    @Column(columnDefinition = "number")
    private Integer fp_Price;

}
