package com.example.demo.theater.specialTheater;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SpecialTheater {
    @Id
    @GeneratedValue
    @Column(name = "special_No", columnDefinition = "number")
    private  Integer specialId;
    @Column(columnDefinition = "varchar2(10)")
    private String special_Name;
}
