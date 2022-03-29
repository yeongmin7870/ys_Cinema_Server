package com.example.demo.theater.vo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenu {
    @Id
    @GeneratedValue
    private Integer food_No;
    private String food_Name;
    private String food_Component;
    private String food_Limit;
    private Date food_Date;
    private Integer food_Price;
}
