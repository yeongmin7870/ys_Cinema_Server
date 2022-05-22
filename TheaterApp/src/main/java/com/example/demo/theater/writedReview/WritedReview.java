package com.example.demo.theater.writedReview;


import com.example.demo.theater.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WritedReview {
    @Id
    @GeneratedValue
    @Column(name="wr_No")
    private Integer wrNo;
    @Column(name="c_Id")
    private String customerId;
    @Column(name="mr_No")
    private Integer mrNo;
    @Column(name="rc_No")
    private Integer rcNo;
}
