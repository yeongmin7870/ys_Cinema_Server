package com.example.demo.theater.answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue
    @Column(name="a_No", columnDefinition = "number")
    private Integer answerId;
    private Integer q_No;
    @Column(columnDefinition = "varchar2(10)")
    private String ad_ID;
    @Column(columnDefinition = "varchar2(60)")
    private String a_Title;
    @Column(columnDefinition = "varchar2(128)")
    private String a_Content;
    @Column(columnDefinition = "date")
    private Date a_Uptime;
}
