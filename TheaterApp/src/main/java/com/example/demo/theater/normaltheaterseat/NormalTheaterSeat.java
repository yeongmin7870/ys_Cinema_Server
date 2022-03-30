package com.example.demo.theater.normaltheaterseat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NormalTheaterSeat {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "varchar2(4)")
    private  String normalTS_No;
}
