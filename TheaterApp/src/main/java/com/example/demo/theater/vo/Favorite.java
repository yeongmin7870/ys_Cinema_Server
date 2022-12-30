package com.example.demo.theater.favorite;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    //현재는 사용안하는 테이블
    @Id
    @GeneratedValue
    private Integer fm_No;
    private Integer c_No;
    private Integer m_No;
}
