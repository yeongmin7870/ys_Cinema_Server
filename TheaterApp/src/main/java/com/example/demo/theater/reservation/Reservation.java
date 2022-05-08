package com.example.demo.theater.reservation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private Integer r_No;
    private Integer r_Movie;
    private Integer r_Date;
    private Date r_Hour;
    private Integer r_Theat;
    @Column(columnDefinition = "varchar2(4)")
    private String r_Seat;
    @Column(columnDefinition = "varchar2(7)")
    private String r_TotalPrice;
    private Integer r_Coupon;
    @Column(columnDefinition = "varchar2(30)")
    private String c_Photo;

}
