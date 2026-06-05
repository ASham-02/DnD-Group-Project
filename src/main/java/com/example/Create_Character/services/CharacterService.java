package com.example.Create_Character.services;

import com.example.Create_Character.models.Character;
import com.example.Create_Character.models.User;
import com.example.Create_Character.repos.CharacterRepo;
import com.example.Create_Character.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepo repo;
    private final UserRepo userRepo; 

    public CharacterService(CharacterRepo repo, UserRepo userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public List<Character> getAll(Long userId) {
        return repo.findByUserId(userId);
    }


    public Character getOne(Long id) {
        return repo.findById(id).orElseThrow();
    }

    // for every user they can create as many characters
    public Character create(Long userId,  Character character) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        character.setUser(user);
        return repo.save(character);
    }


    public Character update(Long id, Character updated) {
        Character existing = repo.findById(id).orElseThrow();
        existing.setCharacterClass(updated.getCharacterClass());
        existing.setElement(updated.getElement());
        existing.setWeight(updated.getWeight());
        existing.setArtwork(updated.getArtwork());
        return repo.save(existing);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}