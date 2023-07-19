package com.sai.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.springboot.entity.UserCredentials;

public interface UserCredentialRepository extends JpaRepository<UserCredentials, Integer>{

	Optional<UserCredentials> findByName(String username);

}
