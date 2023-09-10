package com.login.backend.AuthenticateBackend.Service;

import java.util.List;
import java.util.Optional;

import com.login.backend.AuthenticateBackend.Models.Role;

public interface IRoleService {
    
    List<Role> getRoles();

    Optional<Role> getRoleById(Long id);

    Role saveRole(Role role);

    Role updateRole(Role role);

    Optional<Role> findByAuthority(String authority);

    void deleteRoleById(Long id);
}
