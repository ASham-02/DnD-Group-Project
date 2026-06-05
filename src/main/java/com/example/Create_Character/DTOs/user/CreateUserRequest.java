package com.example.Create_Character.DTOs.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
    @NotBlank(message = "A username is required")
    @Size(min = 2, max = 100, message = "A username must be between 2 to 100 characters")
    String username;

    @NotBlank(message = "A email is required.")
    @Email(message = "It must be a valid email.")
    String email;

    @NotBlank(message = "A password is required")
    String password;

    public @NotBlank String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }
}
