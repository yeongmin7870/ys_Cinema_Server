package com.example.demo.theater.reviewcomment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import oracle.sql.DATE;
import oracle.sql.TIMESTAMP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ReviewComment {

    @Id
    @GeneratedValue
    private Integer rc_No;
    private Integer mr_No;
    private Integer rc_Writer;
    private Long rc_Content;
    private Date rc_Uptime;
    private Integer rc_Thumbs;
    private Integer rc_Bullshit;

}
