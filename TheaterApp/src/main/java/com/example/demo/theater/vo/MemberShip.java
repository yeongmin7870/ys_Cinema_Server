package com.example.demo.theater.vo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MemberShip {
    @Id
    @GeneratedValue
    private Integer m_No;
    private String m_Tier;
}
