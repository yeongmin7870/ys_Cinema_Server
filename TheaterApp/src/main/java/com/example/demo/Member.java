package com.example.demo;

public class Member {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
