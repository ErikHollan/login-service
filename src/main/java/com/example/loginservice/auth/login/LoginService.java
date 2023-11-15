package com.example.loginservice.auth.login;

import com.example.loginservice.auth.ApiResponse;
import com.example.loginservice.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public ApiResponse authenticateUser(LoginRequest loginRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authenticate);

            String token = jwtTokenProvider.createToken(loginRequest.getEmail());
            return new ApiResponse("Login", 200, "Login successful", token);
        } catch (Exception e) {
            return new ApiResponse("Login", 401, LoginErrorHandling.errorMessage(e), null);
        }
    }

}
