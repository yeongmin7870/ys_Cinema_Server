package com.example.demo.theater.vo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StoreAddress {
    @Id
    @GeneratedValue
    private Integer store_No;
    private String store_Address;
    private String store_Owner;
}
