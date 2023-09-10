package com.login.backend.AuthenticateBackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.login.backend.AuthenticateBackend.Models.ApplicationUser;

public interface IUserApplicationService {
    
    List<ApplicationUser> getApplicationUsers();

    Optional<ApplicationUser> getApplicationUserById(Long id);

    ApplicationUser saveApplicationUser(ApplicationUser applicationUser);

    ApplicationUser updateApplicationUser(ApplicationUser applicationUser);

    Optional<ApplicationUser> findByUsername(String username);

    void deleteApplicationUserById(Long id);
}
