package com.example.Create_Character.services;

import com.example.Create_Character.DTOs.user.ApiResponse;
import com.example.Create_Character.DTOs.user.LoginRequest;
import com.example.Create_Character.DTOs.user.RegisterRequest;
import com.example.Create_Character.models.User;
import com.example.Create_Character.repos.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
//    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
//        this.passwordEncoder = passwordEncoder;
    }

    public ApiResponse register(RegisterRequest request) {
        if (userRepo.existsByUsername(request.getUsername())) {
            return new ApiResponse("Username already exists", false, null);
        }
        if (userRepo.existsByEmail(request.getEmail())) {
            return new ApiResponse("Email already exists", false, null);
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

//        String encodedPassword = passwordEncoder.encode(request.getPassword());
//
//        user.setPassword(encodedPassword);
        user.setPassword(request.getPassword());

        userRepo.save(user);

        return new ApiResponse("User registered successfully", true, user.getId());
    }

    public ApiResponse login(LoginRequest request) {
        return userRepo.findByUsername(request.getUsername())
                .map(user -> {
                    if (user.getPassword().equals(request.getPassword())) {
                        return new ApiResponse("Login Successful", true, user.getId());
                    }
                    return  new ApiResponse("Invalid Password", false, null);
                }).orElse(new ApiResponse("User Not Found", false, null));
    }
}
