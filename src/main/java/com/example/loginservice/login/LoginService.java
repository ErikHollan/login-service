package com.example.loginservice.login;

import com.example.loginservice.error.ErrorHandling;
import com.example.loginservice.security.JwtResponse;
import com.example.loginservice.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public ResponseEntity<Map<String, Object>> authenticateUser(LoginRequest loginRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authenticate);

            String token = jwtTokenProvider.createToken(loginRequest.getEmail());
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("token", token);
            return ResponseEntity.ok(successResponse);
        } catch (Exception e) {
            return ErrorHandling.handleAuthenticationException(e);
        }
    }

}
