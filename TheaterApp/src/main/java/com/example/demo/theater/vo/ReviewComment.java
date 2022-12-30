package com.example.demo.theater.vo;

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
    @GeneratedValue
    private Integer reviewCommentId; // 리뷰 아이디 자식키로 받아야됨

    @Column(name = "mr_No", columnDefinition = "number")
    private Integer mrNo;

    @Column(name="rc_Content",columnDefinition = "varchar2(128)")
    private String rcContent;

    @Column(name="rc_Uptime",columnDefinition = "date")
    private Date rcUptime;

    @Column(name="rc_Thumbs",columnDefinition = "number default 0")
    private Integer rcThumbs;

    @Column(name = "rc_Bullshit",columnDefinition = "number default 0")
    private Integer rcBullshit;

}
