package com.example.demo.theater.moviereview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MovieReview {
    @Id
    @GeneratedValue
    @Column(name = "mr_No", columnDefinition = "number")
    private Integer mrId;
    @Column(columnDefinition = "number")
    private Integer m_No;
    @Column(columnDefinition = "varchar2(20)")
    private String mr_Movie;
    @Column(columnDefinition = "varchar2(128)")
    private String mr_Content;
    @Column(columnDefinition = "date")
    private Date mr_Uptime;
    @Column(columnDefinition = "number")
    private Integer mr_Thumbs;
    @Column(columnDefinition = "number")
    private Integer mr_Notgood;


}
