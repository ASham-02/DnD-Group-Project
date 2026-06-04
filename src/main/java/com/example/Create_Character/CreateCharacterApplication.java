package com.example.Create_Character;

import com.example.Create_Character.DTOs.stat.ApiResponse;
import com.example.Create_Character.DTOs.stat.RegisterRequest;
import com.example.Create_Character.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreateCharacterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateCharacterApplication.class, args);
	}
}
