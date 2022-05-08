package com.example.demo.theater.oftenQuestion;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OftenQuestion {
    @Id
    @GeneratedValue
    private Integer often_ID;
    private Integer often_subject;
    private Integer often_Content;
}
