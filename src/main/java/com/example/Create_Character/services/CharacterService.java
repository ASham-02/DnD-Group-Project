package com.example.Create_Character.services;

import com.example.Create_Character.models.Character;
import com.example.Create_Character.repos.CharacterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepo repo;

    public CharacterService(CharacterRepo repo) {
        this.repo = repo;
    }

    public List<Character> getAll(Long userId) {
        return repo.findByUserId(userId);
    }


    public Character getOne(Long id) {
        return repo.findById(id).orElseThrow();
    }


    public Character create(Character character) {
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