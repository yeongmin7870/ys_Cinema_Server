package com.example.demo.theater.moviereview;

import com.example.demo.theater.customer.Customer;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.TIMESTAMP;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Movie_Review")
public class MovieReview {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "mr_No", columnDefinition = "number", unique = true)
    private Integer movieReviewId;

/*    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})*/
    @Column(columnDefinition = "varchar2(10)")
    private String c_Id; //고객 아이디 받아올 값

    @Column(columnDefinition = "number")
    private Integer mno; //영화 아이디 받아올 값
    @Column(columnDefinition = "varchar2(128)")
    private String mr_Content; //영화 리뷰 내용 받아올 값
    @Column(columnDefinition = "date")
    private Date mr_Uptime; // 영화 리뷰 작성 날짜 받아올 값

    @Column(columnDefinition = "number default 0")
    private Integer mr_ReviewStarScore;//별점 받아와야함
    @Column(columnDefinition = "number default 0")
    private Integer mr_Thumbs;
    @Column(columnDefinition = "number default 0")
    private Integer mr_Notgood;


}
