package com.example.Create_Character.Controllers;

import com.example.Create_Character.DTOs.user.ApiResponse;
import com.example.Create_Character.DTOs.user.LoginRequest;
import com.example.Create_Character.DTOs.user.RegisterRequest;
import com.example.Create_Character.models.User;
import com.example.Create_Character.repos.UserRepo;
import com.example.Create_Character.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
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
        ApiResponse response = userService.login(request);

        System.out.println("USERNAME FROM FRONTEND: " + request.getUsername());
        System.out.println("PASSWORD FROM FRONTEND: " + request.getPassword());
        if (response.isSuccess()) {
            return ResponseEntity.ok(response); // 200 OK
        }

        if (response.getMessage().equals("User Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    // finds user by id
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userRepo.findById(id).orElseThrow();
    }
}
