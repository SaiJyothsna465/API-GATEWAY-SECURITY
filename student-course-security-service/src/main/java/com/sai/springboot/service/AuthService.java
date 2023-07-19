package com.sai.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sai.springboot.entity.UserCredentials;
import com.sai.springboot.repo.UserCredentialRepository;

@Service
public class AuthService {

	@Autowired
	private UserCredentialRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	public String saveUser(UserCredentials credential) {
		if (credential.getName() != null) {
			credential.setPassword(passwordEncoder.encode(credential.getPassword()));
			repository.save(credential);
			return "user added to the system";
		} 
		else {
			return "User already exists";
		}

	}

	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}

	public void validateToken(String token) {
		jwtService.validateToken(token);
	}
}
