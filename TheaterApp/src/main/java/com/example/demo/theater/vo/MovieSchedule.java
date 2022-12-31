package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class MovieSchedule {
    @Id
    @NotNull
    @Column(name = "ms_No", columnDefinition = "number", unique = true)
    private Integer movieScheduleId;

    @Column(columnDefinition = "number")
    private Integer store_No; // storeaddress에서 받아온다

    @Column(columnDefinition = "date")
    private Date mS_StarTime;

    @Column(columnDefinition = "date")
    private Date mS_EndTime; // insert-select를 사용해야함

    @Column(columnDefinition = "number")
    private Integer m_No;

}
