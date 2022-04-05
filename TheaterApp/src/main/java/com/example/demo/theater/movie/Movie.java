package com.example.demo.theater.movie;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    private  Integer m_No;
    @Column(columnDefinition = "varchar2(20)")
    private  String m_Name;
    @Column(columnDefinition = "varchar2(10)")
    private String m_Categorie;
    @Column(columnDefinition = "varchar2(51)")
    private String m_Director;
    @Column(columnDefinition = "varchar2(51)")
    private  String m_Actors;
    @Column(columnDefinition = "varchar2(51)")
    private String m_Actor2;
    @Column(columnDefinition = "varchar2(51)")
    private String m_Actor3;
    private Long m_Content;
    private float m_StarScore;
    private Integer m_Rating;
    private Date m_Hour;
    @Column(columnDefinition = "varchar2(30)")
    private String m_Img;
    private Date m_StartDate;
    private Date m_EndDate;

}