package com.login.backend.AuthenticateBackend.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.backend.AuthenticateBackend.Models.ApplicationUser;
import com.login.backend.AuthenticateBackend.Repository.UserRepository;

@Service
public class UserApplicationServiceImpl implements IUserApplicationService{

    @Autowired
    UserRepository userApplicationRepository;

    @Override
    public List<ApplicationUser> getApplicationUsers() {
        return userApplicationRepository.findAll();
    }

    @Override
    public Optional<ApplicationUser> getApplicationUserById(Long id) {
        return userApplicationRepository.findById(id);
    }

    @Override
    public ApplicationUser saveApplicationUser(ApplicationUser applicationUser) {
        return userApplicationRepository.save(applicationUser);
    }

    @Override
    public ApplicationUser updateApplicationUser(ApplicationUser applicationUser) {
        return userApplicationRepository.save(applicationUser);
    }

    @Override
    public Optional<ApplicationUser> findByUsername(String username) {
        return userApplicationRepository.findByUsername(username);
    }

    @Override
    public void deleteApplicationUserById(Long id) {
        userApplicationRepository.deleteById(id);
    }
    
}
