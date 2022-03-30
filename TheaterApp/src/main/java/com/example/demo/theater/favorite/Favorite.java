package com.example.demo.theater.favorite;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue
    private Integer fm_No;
    private Integer c_No;
    @Column(columnDefinition = "varchar2(51)")
    private  String m_Name;
}
