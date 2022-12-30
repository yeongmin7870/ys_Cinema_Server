package com.example.demo.theater.vo;

import com.example.demo.theater.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
