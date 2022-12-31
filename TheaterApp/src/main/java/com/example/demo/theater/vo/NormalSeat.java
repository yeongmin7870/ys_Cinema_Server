package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "normal_Seat")
public class NormalSeat {
    @Id
    @NotNull
    @Column(columnDefinition = "varchar2(10)", unique = true)
    private Integer normalSeatId;
}
