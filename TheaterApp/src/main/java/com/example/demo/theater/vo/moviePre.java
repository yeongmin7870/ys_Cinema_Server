package com.example.demo.theater.vo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class moviePre {
    @Id
    @GeneratedValue
    private  Integer m_No;
    private  String m_Name;
    private String m_Categorie;
    private String m_Director;
    private  String m_Actors;
    private String m_Actor2;
    private String m_Actor3;
    private Long m_Content;
    private float m_StarScore;
    private Integer m_Rating;
    private TIMESTAMP m_Hour;

}
