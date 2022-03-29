package com.example.demo.theater.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class normalTheaterSeat {
    @Id
    @GeneratedValue
    private  Integer normalTheaterSeat_No;
}
