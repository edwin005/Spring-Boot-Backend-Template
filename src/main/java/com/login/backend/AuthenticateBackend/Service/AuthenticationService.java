package com.login.backend.AuthenticateBackend.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.login.backend.AuthenticateBackend.Models.Role;
import com.login.backend.AuthenticateBackend.responses.LoginResponse;
import com.login.backend.AuthenticateBackend.Models.ApplicationUser;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private IUserApplicationService userApplicationService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser(String username, String password){

        String encodedPassword = passwordEncoder.encode(password);

        Role useRole = roleService.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet();

        authorities.add(useRole);

        ApplicationUser applicationUser = new ApplicationUser(0L, username, encodedPassword, authorities);

        return userApplicationService.saveApplicationUser(applicationUser);
    }

    public LoginResponse login(String username, String password){

        try{
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponse(userApplicationService.findByUsername(username).get(), token);
        } catch(AuthenticationException e){
            return new LoginResponse(null, " ");
        }
     }
    
}
