package com.rx.springsecuritydemo.entity;

import lombok.Data;

@Data
public class Users {
    private Long id;

    private String username;

    private String password;
}