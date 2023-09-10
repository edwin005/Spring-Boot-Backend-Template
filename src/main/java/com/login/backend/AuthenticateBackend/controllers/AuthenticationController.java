package com.login.backend.AuthenticateBackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.backend.AuthenticateBackend.Models.ApplicationUser;
import com.login.backend.AuthenticateBackend.Service.AuthenticationService;
import com.login.backend.AuthenticateBackend.requests.LoginRequest;
import com.login.backend.AuthenticateBackend.requests.RegistrationRequest;
import com.login.backend.AuthenticateBackend.responses.LoginResponse;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationRequest registrationRequest){
        return authenticationService.registerUser(registrationRequest.getUsername(), registrationRequest.getPassword());
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }
}
