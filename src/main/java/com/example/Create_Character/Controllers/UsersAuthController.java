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
@RequestMapping(value = "/api/auth/user")
public class UsersAuthController {
    private final UserService userService;

    public UsersAuthController(UserService userService) {
        this.userService = userService;
    }

    // creates user - by getting info username, email and password.
    @PostMapping(value = "/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    // verifying login - if username and password correct return successful login otherwise fail.
    @PostMapping(value = "/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @Autowired
    private UserRepo userRepo;

    // finds user by id
    @GetMapping("{id}")
    public String testUser2(@PathVariable long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return  "user Found: " + user.get().toString();
        } else {
            return "User Not Found";
        }
    }
}
