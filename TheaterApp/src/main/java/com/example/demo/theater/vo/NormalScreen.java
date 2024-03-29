package com.example.demo.theater.vo;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class NormalScreen {
    @Id
    @NotNull
    @Column(columnDefinition = "VARCHAR2(4)", unique = true)
    private String normalScreenId;

    @Column(name = "normal_Screen", columnDefinition = "VARCHAR2(5)")
    private String normalScreen;
}
