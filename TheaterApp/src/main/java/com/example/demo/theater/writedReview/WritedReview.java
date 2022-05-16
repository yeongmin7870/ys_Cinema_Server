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
    /*@ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})*/
    @Column(name="c_Id")
    private String customerId;
    private Integer mr_No;
    private Integer rc_No;
}
