package com.example.demo.theater.normaltheater;

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
public class NormalTheater {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "normalSeat_Id",columnDefinition = "VARCHAR2(10)",unique = true)
    private String normalTheaterId;
    @Column(columnDefinition = "char(1)")
    private String normal_state;

}
