package com.example.demo.theater.eventList;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EventList {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="event_No", columnDefinition="number", unique = true)
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
