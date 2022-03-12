package com.example.demo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

// 데이터들을 담아 놓기 위한 모델
@Entity
@Table
public class Member {

    private Integer id;

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member() {
    }
}
