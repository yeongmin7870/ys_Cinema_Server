package com.example.demo.theater.foodkind;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FoodKind {
    @Id
    @GeneratedValue
    private Integer food_Kind_No;
    @Column(columnDefinition = "varchar2(16)")
    private String food_Kind_Name;
}
