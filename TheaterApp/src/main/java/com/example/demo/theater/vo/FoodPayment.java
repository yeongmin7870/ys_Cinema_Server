package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class FoodPayment {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "fp_No", columnDefinition = "number", unique = true)
    private Integer foodPaymentId;
    @Column(columnDefinition = "number")
    private Integer food_No;
    @Column(columnDefinition = "number")
    private Integer fp_Count;
    @Column(columnDefinition = "number")
    private Integer fp_Price;
    @Column(columnDefinition = "date")
    private Date f_Date;

    @Transient
    private Integer OrderId;
    @Transient
    private String id;
    @Transient
    private Integer nid;

    @Transient
    private String foodName;
    @Transient
    private String food_Component;
    @Transient
    private String food_Limit;
    @Transient
    private Date food_Date;
    @Transient
    private Integer food_Price;
    @Transient
    private String food_Img;
    @Transient
    private Integer foodKindNo;

}
