package com.example.ramobackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequestModel {
    private String username;
    private String userPassword;
}
