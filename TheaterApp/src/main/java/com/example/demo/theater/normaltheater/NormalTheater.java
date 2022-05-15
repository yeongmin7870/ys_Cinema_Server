package com.example.demo.theater.normaltheater;

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
public class NormalTheater {
    @Id
    @GeneratedValue
    @Column(name = "normal_No",columnDefinition = "number")
    private Integer normalId;
    @Column(columnDefinition = "varchar2(5)")
    private String normal_Name;

}
