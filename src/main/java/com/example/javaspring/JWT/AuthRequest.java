package com.example.javaspring.JWT;

import lombok.Data;

@Data
public class AuthRequest {
    private String name;
    private String password;

}
