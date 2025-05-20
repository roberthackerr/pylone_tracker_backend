package com.example.demo.model;

import org.checkerframework.common.aliasing.qual.Unique;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
public class Token {
@Id
@Unique
private String token;
@ManyToOne
@JoinColumn(name = "user_id")
private User user;
public Token(String token) {
    this.token = token;
}

public String getToken() {
    return token;
}

public void setToken(String token) {
    this.token = token;
}
}
