package com.example.loginservice.auth;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponse {
    private String responseType;
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String token;

    public ApiResponse(String responseType, int status, String message, String token) {
        this.timestamp = LocalDateTime.now();
        this.responseType = responseType;
        this.status = status;
        this.message = message;
        this.token = token;
    }
}