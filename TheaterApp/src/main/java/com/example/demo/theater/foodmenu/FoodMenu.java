package com.example.demo.theater.foodmenu;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenu {
    @Id
    @GeneratedValue
    @Column(name="food_No",columnDefinition = "number")
    private Integer foodId;
    @Column(columnDefinition = "varchar2(20)")
    private String food_Name;
    @Column(columnDefinition = "varchar2(30)")
    private String food_Component;
    @Column(columnDefinition = "varchar2(8)")
    private String food_Limit;
    @Column(columnDefinition = "date")
    private Date food_Date;
    @Column(columnDefinition = "number")
    private Integer food_Price;
    @Column(columnDefinition = "varchar2(70)")
    private String food_Img;
    @Column(name="food_Kind_No", columnDefinition = "number")
    private Integer food_Kind_No;
}
