package com.example.ramobackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_password")
    private String userPassword ;

    @Column(name = "local_time", columnDefinition = "TIME")
    private LocalTime localTime = LocalTime.of(6,43,12);

    public User(String username, String userPassword) {
        this.username = username;
        this.userPassword = userPassword;
    }
}
