package com.example.demo.theater.vo;

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
    @Column(name = "mr_No", columnDefinition = "number")
    private Integer movieReviewId;

    /*
     * @ManyToOne(cascade = {CascadeType.DETACH,
     * CascadeType.MERGE,
     * CascadeType.PERSIST,
     * CascadeType.REFRESH})
     */

    @Column(name = "m_no", columnDefinition = "number")
    private Integer movieId; // 영화 아이디 받아올 값
    @Column(name = "mr_content", columnDefinition = "varchar2(128)")
    private String mrContent; // 영화 리뷰 내용 받아올 값
    @Column(name = "mrUptime", columnDefinition = "date")
    private Date mrUptime; // 영화 리뷰 작성 날짜 받아올 값

    @Column(name = "mr_ReviewStarScore", columnDefinition = "number default 0")
    private Integer mrReviewStarScore;// 별점 받아와야함
    @Column(name = "mr_Thumbs", columnDefinition = "number default 0")
    private Integer mrThumbs;
    @Column(name = "mr_NotGood", columnDefinition = "number default 0")
    private Integer mrNotgood;

    // WritedReview VO
    @Transient
    private String cId;
    @Transient
    private Integer rcNo;

    @Transient
    private String imageUri; // 리뷰단 사람 프로필 가져오기
    @Transient
    private String c_Nikname; // 리뷰 단 사람 닉네임 가져오기
}
