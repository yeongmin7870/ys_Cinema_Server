package com.example.demo.theater.specialTheater;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SpecialTheater {
    @Id
    @GeneratedValue
    private  Integer special_No;
    @Column(columnDefinition = "varchar2(10)")
    private String special_Name;
}
