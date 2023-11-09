package com.example.loginservice.login;

import com.example.loginservice.security.JwtResponse;
import com.example.loginservice.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1")
public class LoginController {

    private final LoginService loginService;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = loginService.authenticateUser(loginRequest);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/check")
    public String test (@RequestParam("token") String token){
        return jwtTokenProvider.getEmailFromToken(token);
    }


}