package com.example.concerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class ConcertsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConcertsApplication.class, args);
	}
}