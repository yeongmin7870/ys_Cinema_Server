package com.example.demo.theater.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Admin {
    @Id
    @Column(name = "ad_ID", columnDefinition = "varchar2(10)")
    private String adminID;
    @Column(name = "ad_PW", columnDefinition = "varchar2(16)")
    private String adminPW;
    @Column(name = "ad_Position", columnDefinition = "varchar2(18)")
    private String adPosition;
}
