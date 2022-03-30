package com.example.demo.theater.normaltheater;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NormalTheater {
    @Id
    @GeneratedValue
    private Integer normal_No;
    @Column(columnDefinition = "varchar2(5)")
    private String normal_Name;

}
