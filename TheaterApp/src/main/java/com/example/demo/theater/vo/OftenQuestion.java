package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OftenQuestion {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "often_ID", columnDefinition = "number", unique = true)
    private Integer oftenID;

    @Column(columnDefinition = "varchar2(60)")
    private String often_subject;

    @Column(columnDefinition = "varchar2(128)")
    private String often_Content;

    @Column(columnDefinition = "varchar2(128)")
    private String often_Answer;
}
