package com.example.demo.theater.normaltheaterseat;

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
public class NormalTheaterSeat {
    @Id
    @NotNull
    @Column(name = "normalTS_No",columnDefinition = "varchar2(5)")
    private  String normalTSId;
    @Column(columnDefinition = "number")
    private Integer normal_No;
}
