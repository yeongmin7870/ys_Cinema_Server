package com.example.demo.theater.movieSchedule;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MovieSchedule {
    @Id
    @GeneratedValue
    private Integer mS_No;
    private Integer store_No;
    private Date mS_StarTime;
    private Date mS_EndTime;
    private Integer m_No;
}
