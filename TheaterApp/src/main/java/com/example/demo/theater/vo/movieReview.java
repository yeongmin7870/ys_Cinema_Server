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
public class movieReview {
    @Id
    @GeneratedValue
    private Integer mr_No;
    private String mr_Movie;
    private Integer mr_Writer;
    private TIMESTAMP mr_Uptime;
    private Integer mr_Thumbs;
    private Integer mr_Bullshit;

}
