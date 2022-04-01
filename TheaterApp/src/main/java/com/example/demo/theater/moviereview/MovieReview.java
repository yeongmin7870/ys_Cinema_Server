package com.example.demo.theater.moviereview;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MovieReview {
    @Id
    @GeneratedValue
    private Integer mr_No;
    @Column(columnDefinition = "varchar2(20)")
    private String mr_Movie;
    private Integer mr_Writer;
    private Long mr_Content;
    private Date mr_Uptime;
    private Integer mr_Thumbs;
    private Integer mr_Bullshit;


}
