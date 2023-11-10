package com.example.loginservice.login;

import com.example.loginservice.security.JwtResponse;
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
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        return loginService.authenticateUser(loginRequest);
    }

    @GetMapping("/check")
    public String test (@RequestParam("token") String token){
        return jwtTokenProvider.getEmailFromToken(token);
    }
}
