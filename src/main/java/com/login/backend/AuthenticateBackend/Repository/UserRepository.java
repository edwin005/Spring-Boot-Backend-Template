package com.login.backend.AuthenticateBackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.backend.AuthenticateBackend.Models.ApplicationUser;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long>{
    Optional<ApplicationUser> findByUsername(String username);
}
