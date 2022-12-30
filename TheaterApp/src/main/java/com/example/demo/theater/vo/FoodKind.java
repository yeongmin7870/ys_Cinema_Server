package com.example.demo.theater.vo;

import com.example.demo.theater.vo.foodmenu.FoodMenu;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Food_Kind")
public class FoodKind {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "food_Kind_No", columnDefinition = "number", unique = true)
    private Integer foodKindId;
    @Column(name = "food_Kind_Name", columnDefinition = "varchar2(16)")
    private String foodKindName;

}
