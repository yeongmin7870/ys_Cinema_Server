package com.example.demo.theater.foodmenu;


import com.sun.istack.NotNull;
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
    @NotNull
    @Column(name="food_No",columnDefinition = "number", unique = true)
    private Integer foodMenuId;
    @Column(columnDefinition = "varchar2(30)")
    private String food_Name;
    @Column(columnDefinition = "varchar2(55)")
    private String food_Component;
    @Column(columnDefinition = "varchar2(30)")
    private String food_Limit;
    @Column(columnDefinition = "date")
    private Date food_Date;
    @Column(columnDefinition = "number")
    private Integer food_Price;
    @Column(columnDefinition = "varchar2(70) default './src/main/resources/serverImage/foodImage/food_none.png'")
    private String food_Img;
//    @Column(columnDefinition = "varchar2(70) default 'None'")
//    private String food_Img_Path;
    @Column(columnDefinition = "number")
    private Integer food_Kind_No;
}
