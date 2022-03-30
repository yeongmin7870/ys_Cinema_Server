package com.example.demo.theater.membership;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @Column(columnDefinition = "varchar2(9)")
    private String m_Tier;
}
