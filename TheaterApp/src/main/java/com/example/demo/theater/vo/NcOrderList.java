package com.example.demo.theater.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NcOrderList {
    @Id
    @GeneratedValue
    @Column(name = "ncOrderId", columnDefinition = "number", unique = true, nullable = false)
    private Integer ncOrderId;
    private Integer nc_No; // nc id
    private Integer fp_No;
    private Integer r_No;
}
