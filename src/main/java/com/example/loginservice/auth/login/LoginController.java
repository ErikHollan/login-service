package com.example.loginservice.auth.login;

import com.example.loginservice.auth.ApiResponse;
import com.example.loginservice.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1")
public class LoginController {

    private final LoginService loginService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest loginRequest) {
        ApiResponse response = loginService.authenticateUser(loginRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/check")
    public String test(@RequestParam("token") String token) {
        return jwtTokenProvider.getEmailFromToken(token);
    }
}
