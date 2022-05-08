package com.example.demo.theater.writedReview;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WritedReview {
    @Id
    @Column(columnDefinition = "varchar2(10)")
    private Integer c_Id;
    private Integer mr_No;
    private Integer rc_No;
}
