package com.login.backend.AuthenticateBackend.responses;

import com.login.backend.AuthenticateBackend.Models.ApplicationUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private ApplicationUser applicationUser;
    private String jwt;
}
