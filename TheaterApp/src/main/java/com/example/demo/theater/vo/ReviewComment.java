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
public class ReviewComment {

    @Id
    @GeneratedValue
    private Integer rc_No;
    private Integer mr_No;
    private Integer rc_Writer;
    private TIMESTAMP rc_Uptime;
    private Integer rc_Thumbs;
    private Integer rc_Bullshit;

}
