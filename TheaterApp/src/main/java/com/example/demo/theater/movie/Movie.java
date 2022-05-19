package com.example.demo.theater.movie;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name="m_No",columnDefinition = "number", unique = true)
    private Integer movieId; //영화번호
    @Column(columnDefinition = "varchar2(40)") //기본적으로 20 자가 넘어가기때문에 넉넉하게 40줬습니다
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
    @Column(columnDefinition = "varchar2(128)")
    private String m_Content;//줄거리
    @Column(columnDefinition = "float")
    private Float m_StarScore; //평점
    @Column(columnDefinition = "number")
    private Integer m_Rating; //별점 갯수
    @Column(columnDefinition = "varchar2(10)")
    private String m_Hour;
    //위의 상영시간 부분은 ~~~분이라고 출력이 되어야 하는데 그것이 DATE 타입으론 불편하여서 varchar2(7) 로 수정했습니다.

    @Column(columnDefinition = "varchar2(70)")
    private String m_Img;
    @Column(columnDefinition = "varchar2(70) default './src/main/resources/serverImage/movieImage/'")  // 이미지 경로컬럼
    private String m_ImagePath;
    @Column(columnDefinition = "date")
    private Date m_StartDate;
    @Column(columnDefinition = "date")
    private Date m_EndDate;

    @Column(columnDefinition = "varchar2(70) default './src/main/resources/movieVideo/'")
    private String movieVideoPath;     // 영화 비디오 경로
    @Column(columnDefinition = "varchar2(70)")
    private String movieVideoName; // 영화 비디오 드름

    @Column(columnDefinition = "varchar2(18)")
    private String m_tier;


}
