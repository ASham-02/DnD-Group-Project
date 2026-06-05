package com.example.Create_Character.repos;

import com.example.Create_Character.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(long id);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
