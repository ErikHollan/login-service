package com.example.loginservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ErrorHandling {

    public static ResponseEntity<Map<String, Object>> handleAuthenticationException(Exception e) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.UNAUTHORIZED.value());
        errorResponse.put("error", HttpStatus.UNAUTHORIZED.getReasonPhrase());

        if (e instanceof BadCredentialsException) {
            errorResponse.put("message", "Invalid email and/or password");
        } else if (e instanceof LockedException) {
            errorResponse.put("message", "Account locked");
        } else if (e instanceof DisabledException) {
            errorResponse.put("message", "Account disabled");
        } else {
            errorResponse.put("message", "Authentication failed");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
}
