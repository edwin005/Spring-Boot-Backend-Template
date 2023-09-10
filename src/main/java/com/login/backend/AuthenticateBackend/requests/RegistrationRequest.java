package com.login.backend.AuthenticateBackend.requests;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegistrationRequest {

    @NonNull
    private String username;

    @NonNull
    private String password;
    
}
