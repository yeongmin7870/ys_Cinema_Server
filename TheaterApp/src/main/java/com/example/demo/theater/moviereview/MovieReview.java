package com.example.demo.theater.moviereview;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Movie_Review")
public class MovieReview {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "mr_No", columnDefinition = "number", unique = true)
    private Integer movieReviewId;
    @Column(columnDefinition = "number")
    private Integer m_No;
    @Column(columnDefinition = "varchar2(128)")
    private String mr_Content;
    @Column(columnDefinition = "date")
    private Date mr_Uptime;
    @Column(columnDefinition = "number")
    private Integer mr_Thumbs;
    @Column(columnDefinition = "number")
    private Integer mr_Notgood;


}
