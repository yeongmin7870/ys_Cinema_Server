package com.example.demo.theater.specialTheaterSeat;

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
public class SpecialTheaterSeat {
    @Id
    @GeneratedValue
    @Column(name = "specialTS_No",columnDefinition = "varchar2(4)")
    private String specialTSId;
    @Column(columnDefinition = "varchar2(10)")
    private  Integer special_Name;
}
