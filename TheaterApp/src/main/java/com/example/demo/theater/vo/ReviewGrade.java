package com.example.demo.theater.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ReviewGrade {
    @Id
    @GeneratedValue
    private Integer rg_No;
    private String rg_Tier;


}
