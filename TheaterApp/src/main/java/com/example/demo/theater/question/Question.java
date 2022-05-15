package com.example.demo.theater.question;

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
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "q_No", columnDefinition = "number")
    private Integer qId;
    @Column(columnDefinition = "VARCHAR2(10)")
    private String c_id;
    @Column(columnDefinition = "VARCHAR2(10)")
    private String q_Kind;
    @Column(columnDefinition = "VARCHAR2(60)")
    private String q_Title;
    @Column(columnDefinition = "VARCHAR2(128)")
    private String q_Content;
    @Column(columnDefinition = "date")
    private Date q_Uptime;
}
