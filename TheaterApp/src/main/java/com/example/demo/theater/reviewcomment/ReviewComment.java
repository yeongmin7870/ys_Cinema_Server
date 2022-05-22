package com.example.demo.theater.reviewcomment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;
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
public class ReviewComment {

    @Id
    @Column(name = "rc_No",columnDefinition = "number")
    private Integer rcId; // 리뷰 아이디 자식키로 받아야됨


    @Column(name = "mr_No", columnDefinition = "number")
    private Integer mrNo;

    @Column(columnDefinition = "varchar2(128)")
    private String rc_Content;

    @Column(columnDefinition = "date")
    private Date rc_Uptime;

    @Column(columnDefinition = "number")
    private Integer rc_Thumbs;

    @Column(columnDefinition = "number")
    private Integer rc_Bullshit;

}
