package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class SpecialTheater {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "special_Id", columnDefinition = "varchar2(10)", unique = true)
    private Integer specialId;
    @Column(columnDefinition = "char(1)")
    private String special_state;
}
