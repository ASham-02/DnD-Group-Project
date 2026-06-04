package com.example.Create_Character.services;

import com.example.Create_Character.DTOs.stat.ApiResponse;
import com.example.Create_Character.DTOs.stat.LoginRequest;
import com.example.Create_Character.DTOs.stat.RegisterRequest;
import com.example.Create_Character.models.User;
import com.example.Create_Character.repos.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public ApiResponse register(RegisterRequest request) {
        if (userRepo.existsByUsername(request.getUsername())) {
            return new ApiResponse("Username already exists", false);
        }
        if (userRepo.existsByEmail(request.getEmail())) {
            return new ApiResponse("Email already exists", false);
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepo.save(user);

        return new ApiResponse("User registered successfully", true);
    }

    public ApiResponse login(LoginRequest request) {
        return userRepo.findByUsername(request.getUsername())
                .map(user -> {
                    if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                        return new ApiResponse("Login Successful", true);
                    }
                    return  new ApiResponse("Invalid Credential", false);
                }).orElse(new ApiResponse("User Not Found", false));
    }
}
