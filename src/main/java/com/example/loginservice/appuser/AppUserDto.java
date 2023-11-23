package com.example.loginservice.appuser;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class AppUserDto {
    private final String firstName;
    private final String lastName;
    private final String email;
}
