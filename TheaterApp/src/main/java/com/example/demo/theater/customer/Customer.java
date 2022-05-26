package com.example.demo.theater.customer;


import com.google.gson.annotations.SerializedName;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @NotNull
    @Column(name = "c_Id",columnDefinition = "varchar2(10)", unique = true)
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
    @Column(columnDefinition = "number default 0")
    private Integer c_Total; // 총소비금액
    @Column(columnDefinition = "number default 0")
    private Integer c_Point; // 적립포인트
    @Column(columnDefinition = "varchar2(70) default 'profile.jpeg'")
    private String c_Profile; // 프로필이미지
    @Column(columnDefinition = "varchar2(70) default './src/main/resources/serverImage/profile/'")
    private String c_Profile_Path;

}
