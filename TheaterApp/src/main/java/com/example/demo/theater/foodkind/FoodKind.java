package com.example.demo.theater.foodkind;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FoodKind {
    @Id
    @GeneratedValue
    @Column(name = "food_Kind_No", columnDefinition = "number")
    private Integer foodKindId;
    @Column(columnDefinition = "varchar2(16)")
    private String food_Kind_Name;
}
