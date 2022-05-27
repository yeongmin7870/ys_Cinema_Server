package com.example.demo.theater.normalScreen;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class NormalScreen {
    @Id
    @NotNull
    @Column(name = "normal_SID", columnDefinition = "VARCHAR2(4)", unique = true)
    private String normalScreenId;

    @Column(name = "normal_Screen", columnDefinition = "VARCHAR2(5)")
    private String normalScreen;
}
