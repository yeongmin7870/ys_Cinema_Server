package com.example.demo.theater.storeaddress;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @Column(columnDefinition = "varchar2(105)")
    private String store_Address;
    @Column(columnDefinition = "varchar2(51)")
    private String store_Owner;
}
