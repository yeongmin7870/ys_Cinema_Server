package com.example.demo.theater.nonCustomer;

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
public class NonCustomer {
    @Id
    @GeneratedValue
    @Column(name = "nc_No",columnDefinition = "number")
    private Integer ncId;
    @Column(columnDefinition = "VARCHAR2(51)")
    private String nc_Name;
    @Column(columnDefinition = "VARCHAR2(11)")
    private String nc_Phone;
}
