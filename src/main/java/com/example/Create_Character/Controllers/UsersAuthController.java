package com.example.Create_Character.Controllers;

import com.example.Create_Character.DTOs.user.ApiResponse;
import com.example.Create_Character.DTOs.user.LoginRequest;
import com.example.Create_Character.DTOs.user.RegisterRequest;
import com.example.Create_Character.models.User;
import com.example.Create_Character.repos.UserRepo;
import com.example.Create_Character.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users/auth")
public class UsersAuthController {
    private final UserService userService;

    public UsersAuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @Autowired
    private UserRepo userRepo;

    // testing if username exist
    @GetMapping("/test/{username}")
    public String testUser2(@PathVariable String username) {
        Optional<User> user = userRepo.findByUsername(username);
        System.out.println("is user present> " + user.isPresent());
        if (user.isPresent()) {
            return  "user Found: " + user.get().toString();
        } else {
            return "User Not Found";
        }
    }
}
