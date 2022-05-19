package com.example.demo.theater.foodkind;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Food_Kind")
public class FoodKind {
    @Id
    @NotNull
    @Column(name = "food_Kind_No", columnDefinition = "number")
    private Integer foodKindId;
    @Column(columnDefinition = "varchar2(16)")
    private String food_Kind_Name;
}
