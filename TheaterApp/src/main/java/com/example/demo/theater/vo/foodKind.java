package com.example.demo.theater.vo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class foodKind {
    @Id
    @GeneratedValue
    private Integer food_Kind_No;
    private String food_Kind_Name;
}
