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
public class Reservation {
    @Id
    @GeneratedValue
    private Integer r_No;
    private Integer r_Movie;
    private Integer r_Date;
    private TIMESTAMP r_Hour;

}
