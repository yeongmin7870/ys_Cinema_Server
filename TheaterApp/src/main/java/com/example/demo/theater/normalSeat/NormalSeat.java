package com.example.demo.theater.normalSeat;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "normal_Seat")
public class NormalSeat {
    @Id
    @NotNull
    @GeneratedValue
    @Column(columnDefinition = "number()")
    private Integer normalId;
    @Column(columnDefinition = "VARCHAR2(10)",unique = true)
    private String normalSeatId;
}
