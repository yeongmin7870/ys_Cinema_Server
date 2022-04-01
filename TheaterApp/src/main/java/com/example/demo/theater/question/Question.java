package com.example.demo.theater.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Integer q_No;
    private  Integer q_Writer;
    @Column(columnDefinition = "VARCHAR2(60)")
    private String q_Title;
    private Long q_Content;
    private Date q_Uptime;
}
