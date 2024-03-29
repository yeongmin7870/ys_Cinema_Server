package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "q_No", columnDefinition = "number", unique = true)
    private Integer QuestionId;
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
