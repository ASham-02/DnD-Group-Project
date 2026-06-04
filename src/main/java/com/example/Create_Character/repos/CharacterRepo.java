package com.example.Create_Character.repos;

import com.example.Create_Character.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepo extends JpaRepository<Character, Long> {

    List<Character> findByUserId(Long userId);

}