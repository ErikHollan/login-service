package com.example.loginservice.auth.login;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;

public class LoginErrorHandling {

    public static String errorMessage (Exception e) {

        if (e instanceof BadCredentialsException) {
            return "Invalid email and/or password";
        } else if (e instanceof LockedException) {
            return "Account locked";
        } else if (e instanceof DisabledException) {
            return "Account disabled";
        } else {
            return  "Authentication failed";
        }
    }
}
