package com.login.backend.AuthenticateBackend;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.login.backend.AuthenticateBackend.Models.ApplicationUser;
import com.login.backend.AuthenticateBackend.Models.Role;
import com.login.backend.AuthenticateBackend.Repository.RoleRepository;
import com.login.backend.AuthenticateBackend.Repository.UserRepository;

@SpringBootApplication
public class AuthenticateBackendApplication {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticateBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository UserRepository, PasswordEncoder passwordEncoder ){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;

			Role adminRole = roleRepository.save(new Role(1L, "ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser adminUser = new ApplicationUser(1L, "admin", passwordEncoder.encode("Password"), roles);
			userRepository.save(adminUser);
		};
	}

}
