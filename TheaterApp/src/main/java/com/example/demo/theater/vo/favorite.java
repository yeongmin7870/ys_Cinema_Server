package com.example.demo.theater.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class favorite {
    @Id
    @GeneratedValue
    private Integer fm_No;
    private String fm_CustNO;
    private  String m_Name;
}
