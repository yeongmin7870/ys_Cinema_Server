package com.example.demo.theater.reviewgrade;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @Column(columnDefinition = "varchar2(9)")
    private String rg_Tier;


}
