package com.login.backend.AuthenticateBackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.backend.AuthenticateBackend.Models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByAuthority(String authority);
}
