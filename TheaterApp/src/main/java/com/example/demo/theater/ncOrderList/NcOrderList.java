package com.example.demo.theater.ncOrderList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NcOrderList {
    @Id
    @GeneratedValue
    private Integer nc_No;
    private Integer fp_No;
    private Integer r_No;
}
