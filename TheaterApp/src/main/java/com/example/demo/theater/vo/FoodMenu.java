package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenu {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "food_No", columnDefinition = "number", unique = true)
    private Integer foodMenuId;
    @Column(name = "food_Name", columnDefinition = "varchar2(30)")
    private String foodName;
    @Column(columnDefinition = "varchar2(55)")
    private String food_Component;
    @Column(columnDefinition = "varchar2(30)")
    private String food_Limit;
    @Column(columnDefinition = "date")
    private Date food_Date;
    @Column(columnDefinition = "number")
    private Integer food_Price;
    @Column(columnDefinition = "varchar2(70) default './src/main/resources/serverImage/foodImage/food_none.jpeg'")
    private String food_Img;
    @Column(name = "foodKindNo", columnDefinition = "number")
    private Integer foodKindNo;

    @Transient // 디비에는 들어가지 않는 변수
    private String foodKindName;
}
