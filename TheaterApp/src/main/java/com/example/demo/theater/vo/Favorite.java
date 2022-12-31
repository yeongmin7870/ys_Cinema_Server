package com.example.demo.theater.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Favorite {
    // 현재는 사용안하는 테이블
    @Id
    @GeneratedValue
    private Integer fm_No;
    private Integer c_No;
    private Integer m_No;
}
