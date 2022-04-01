package com.example.demo.theater.foodmenu;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenu {
    @Id
    @GeneratedValue
    private Integer food_No;
    @Column(columnDefinition = "varchar2(20)")
    private String food_Name;
    @Column(columnDefinition = "varchar2(30)")
    private String food_Component;
    @Column(columnDefinition = "varchar2(8)")
    private String food_Limit;
    private Date food_Date;
    private Integer food_Price;
    private Blob food_Img;
    private Integer food_Kind_No;
}
