package com.example.loginservice.auth.registration;

import com.example.loginservice.auth.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<ApiResponse>register(@RequestBody RegistrationRequest request) {
        ApiResponse response = registrationService.register(request);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
