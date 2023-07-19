package com.sai.microservices.studentmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.sai.microservice.controller", "com.sai.microservice.service"})
@EntityScan("com.sai.microservice.entity")
@EnableJpaRepositories("com.sai.microservice.repo")
@EnableFeignClients("com.sai.microservice.feignclients")
@EnableEurekaClient
public class StudentMicroserviceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StudentMicroserviceApplication.class, args);
	}
	
	
	
}
