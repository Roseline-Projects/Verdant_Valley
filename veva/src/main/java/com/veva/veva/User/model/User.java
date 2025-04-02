package com.veva.veva.User.model;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String email;
    private String password;
    private Origin origin;

    public User() {}

    public User(String username, String email, String password, Origin origin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.origin = origin;
    }

    @Override
    public String toString() {
        return String.format("User: Id=%d, username=%s", userId, username);
    }

}
