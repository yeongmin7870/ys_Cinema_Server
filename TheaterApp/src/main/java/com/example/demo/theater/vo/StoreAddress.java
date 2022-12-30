package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
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
public class StoreAddress {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "store_No", columnDefinition = "number")
    private Integer storeId;
    @Column(columnDefinition = "varchar2(105)")
    private String store_Address;
    @Column(columnDefinition = "varchar2(51)")
    private String store_Owner;
}
