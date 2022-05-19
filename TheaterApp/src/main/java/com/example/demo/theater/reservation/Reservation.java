package com.example.demo.theater.reservation;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @Column(columnDefinition = "date")
    private Date r_Date;
    //@Column(columnDefinition = "varchar2(10)")
    //private String r_Hour;
    @Column(columnDefinition = "varchar2(4)")
    private String r_Seat;
    @Column(columnDefinition = "varchar2(7)")
    private String r_TotalPrice;
    @Column(columnDefinition = "number")
    private Integer r_Coupon;
    @Column(columnDefinition = "varchar2(70)")
    private String c_Photo;

}
