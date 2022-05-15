package com.example.demo.theater.movie;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    @Column(name="m_No",columnDefinition = "number")
    private Integer movieId; //영화번호
    @Column(columnDefinition = "varchar2(20)")
    private String m_Name; //영화네임
    @Column(columnDefinition = "varchar2(10)")
    private String m_Categories; //영화장르
    @Column(columnDefinition = "varchar2(51)")
    private String m_Director; //영화감독
    @Column(columnDefinition = "varchar2(51)")
    private String m_Actors; // 출연진1
    @Column(columnDefinition = "varchar2(51)")
    private String m_Actor2; // 출연진2
    @Column(columnDefinition = "varchar2(51)")
    private String m_Actor3;// 출연진3
    @Column(columnDefinition = "long")
    private String m_Content;//줄거리
    @Column(columnDefinition = "float")
    private Float m_StarScore;
    @Column(columnDefinition = "number")
    private Integer m_Rating;
    @Column(columnDefinition = "varchar2(10)")
    private String m_Hour;
    //위의 상영시간 부분은 ~~~분이라고 출력이 되어야 하는데 그것이 DATE 타입으론 불편하여서 varchar2(7) 로 수정했습니다.

    @Column(columnDefinition = "varchar2(70)")
    private String m_Img;
    @Column(columnDefinition = "date")
    private Date m_StartDate;
    @Column(columnDefinition = "date")
    private Date m_EndDate;

}
