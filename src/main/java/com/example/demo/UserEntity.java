package com.example.demo;

import javax.persistence.*;

@Entity
@Table (name = "UserEntity")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column (name = "id", nullable = false)
    private Integer id;


    @Column (name = "UserName", length = 64, nullable = false)
    private String UserName;

    public UserEntity() {
    }

    public UserEntity (String name) {
        this.UserName = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String un) {
        this.UserName = un;
    }
}
