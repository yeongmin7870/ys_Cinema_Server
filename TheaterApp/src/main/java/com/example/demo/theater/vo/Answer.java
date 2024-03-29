package com.example.demo.theater.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue
    @Column(name = "a_No", columnDefinition = "number")
    private Integer answerId;

    @Column(name = "q_No", columnDefinition = "number")
    private Integer qNo;
    @Column(name = "ad_ID", columnDefinition = "varchar2(10)")
    private String adminID;
    @Column(name = "a_Title", columnDefinition = "varchar2(60)")
    private String aTitle;
    @Column(name = "a_Content", columnDefinition = "varchar2(128)")
    private String aContent;
    @Column(name = "a_Uptime", columnDefinition = "date")
    private Date aUptime;
}
