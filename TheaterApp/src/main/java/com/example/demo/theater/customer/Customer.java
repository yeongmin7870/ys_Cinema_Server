package com.example.demo.theater.customer;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Blob;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Integer c_No;  // 회원번호
    @Column(name = "c_Id",columnDefinition = "varchar2(10)")
    private String customerId; //회원아이디
    @Column(columnDefinition = "varchar2(16)")
    private String c_Pw; //회원 비밀번호
    @Column(columnDefinition = "varchar2(51)")
    private String c_Name; //회원명
    @Column(columnDefinition = "varchar2(24)")
    private String c_Nikname;
    @Column(columnDefinition = "varchar2(11)")
    private String c_Phone; // 회원 전화번호
    @Column(columnDefinition = "varchar2(105)")
    private String c_Address; //회원 주소
    private Integer c_Total;
    private Integer c_Point;
    @Column(columnDefinition = "varchar2(30)")
    private String c_Profile;


}