package com.example.demo.theater.vo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class customer {
    @Id
    @GeneratedValue
    private Integer c_No;  // 회원번호
    private String c_id; //회원아이디
    private String c_Pw; //회원 비밀번호
    private String c_Name; //회원명
    private String c_Phone; // 회원 전화번호
    private String c_Address; //회원 주소


}
