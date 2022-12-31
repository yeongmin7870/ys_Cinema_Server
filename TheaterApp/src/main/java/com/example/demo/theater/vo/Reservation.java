package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "r_No", columnDefinition = "number", unique = true)
    private Integer reservationId;
    @Column(columnDefinition = "number")
    private Integer m_No;
    @Column(name = "ms_no", columnDefinition = "number")
    private Integer msNo;
    @Column(columnDefinition = "date")
    private Date r_Date;
    @Column(columnDefinition = "varchar2(7)")
    private String r_TotalPrice;
    @Column(columnDefinition = "number")
    private Integer r_Coupon;
    @Column(columnDefinition = "varchar2(70)")
    private String c_Photo;
    @Column(columnDefinition = "VARCHAR2(7)")
    private String normalSeatId;
    @Column(columnDefinition = "VARCHAR2(10)")
    private String normalScreenId;

    // vo 를 위한 변수 선언
    @Transient
    private Integer orderId;
    @Transient
    private String cId;
    @Transient
    private Integer nId;

    @Transient
    private String m_Name; // 영화네임
    @Transient
    private String m_Categories; // 영화장르
    @Transient
    private String m_Director; // 영화감독
    @Transient
    private String m_Actors; // 출연진1
    @Transient
    private String m_Actor2; // 출연진2
    @Transient
    private String m_Actor3;// 출연진3
    @Transient
    private String m_Content;// 줄거리
    @Transient
    private Float m_StarScore; // 평점
    @Transient
    private Integer m_Rating; // 별점 갯수
    @Transient
    private String m_Hour;

    @Transient
    private String m_Img;
    @Transient
    private String m_ImagePath;
    @Transient
    private Date m_StartDate;
    @Transient
    private Date m_EndDate;

    @Transient
    private String movieVideoPath; // 영화 비디오 경로
    @Transient
    private String movieVideoName; // 영화 비디오 드름
    @Transient
    private String m_tier;

}
