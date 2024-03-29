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
public class EventList {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "event_No", columnDefinition = "number", unique = true)
    private Integer eventId;
    @Column(columnDefinition = "VARCHAR2(10)")
    private String ad_ID;
    @Column(columnDefinition = "VARCHAR2(70)")
    private String event_Subject;
    @Column(columnDefinition = "date")
    private Date event_Startdate;
    @Column(columnDefinition = "date")
    private Date event_Enddate;
    @Column(columnDefinition = "VARCHAR2(70) default './src/main/resources/serverImage/eventImage/'")
    private String event_Img;
    @Column(columnDefinition = "number default 0")
    private Integer event_Hits;
}
