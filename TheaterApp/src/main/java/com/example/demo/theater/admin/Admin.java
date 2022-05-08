package com.example.demo.theater.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Admin {
    @Id
    @Column(columnDefinition = "varchar2(10)")
    private String ad_ID;
    @Column(columnDefinition = "varchar2(16)")
    private String ad_PW;
    @Column(columnDefinition = "varchar2(18)")
    private String ad_Position;


}
