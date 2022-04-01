package com.example.demo.theater.eventnowList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

@Entity
public class EventnowList {
    @Id
    @GeneratedValue
    private Integer event_No;
    @Column(columnDefinition = "VARCHAR2(70)")
    private String event_Subject;
    private Date event_Startdate;
    private Date event_Enddate;
    private Blob event_Img;
    private Integer event_Hits;
}
