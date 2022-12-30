package com.example.demo.theater.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodMK {

    private Integer foodMenuId;
    private String foodName;
    private String food_Component;
    private String food_Limit;
    private Date food_Date;
    private Integer food_Price;
    private String food_Img;
    private Integer food_Kind_No;


    private Integer foodKindId;
    private String foodKindName;
}
