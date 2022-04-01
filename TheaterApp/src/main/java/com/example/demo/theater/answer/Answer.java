package com.example.demo.theater.answer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Integer a_No;
    private Integer a_Writer;
    @Column(columnDefinition = "varchar2(60)")
    private String a_Title;
    private Long a_Content;
    private Date a_Uptime;
}
