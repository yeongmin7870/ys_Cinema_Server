package com.example.demo.theater.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
    private Integer normal_Name;
    private String m_Name;

}
