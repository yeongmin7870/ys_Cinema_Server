package com.example.demo.theater.theaterDvi;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDvi {
    @Id
    @GeneratedValue
    private Integer mS_No;
    private Integer normal_No;
    private Integer special_No;
}
