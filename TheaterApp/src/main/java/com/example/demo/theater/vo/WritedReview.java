package com.example.demo.theater.vo;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class WritedReview {
    @Id
    @GeneratedValue
    @Column(name = "wr_no", columnDefinition = "Number")
    private Integer wrNo;
    @Column(name = "c_Id", columnDefinition = "varchar2(16)")
    private String cId;
    @Column(name = "mr_No", columnDefinition = "number default 0")
    private Integer mrNo;
    @Column(name = "rc_No", columnDefinition = "number default 0")
    private Integer rcNo;
}
