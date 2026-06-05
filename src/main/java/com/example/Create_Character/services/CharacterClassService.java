package com.example.Create_Character.services;

import com.example.Create_Character.DTOs.characterclass.ClassResponse;
import com.example.Create_Character.DTOs.characterclass.CreateClassRequest;
import com.example.Create_Character.DTOs.stat.StatsResponse;
import com.example.Create_Character.models.CharacterClass;
import com.example.Create_Character.models.Stat;
import com.example.Create_Character.repos.CharacterClassRepo;
import com.example.Create_Character.repos.StatsRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterClassService {

    private final CharacterClassRepo characterClassRepo;
    private final StatsRepo statsRepo;

    public CharacterClassService(CharacterClassRepo characterClassRepo, StatsRepo statsRepo) {
        this.characterClassRepo = characterClassRepo;
        this.statsRepo = statsRepo;
    }

    public ClassResponse addCharacterClass(CreateClassRequest newCharacterClassRequest) {

        if (characterClassRepo.existsByName(newCharacterClassRequest.getName())) {
            throw new IllegalArgumentException("This class is already in use!");
        }


        Stat stat = statsRepo.findById(newCharacterClassRequest.getStatsId())
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Stat with ID %d not found", newCharacterClassRequest.getStatsId())));


        CharacterClass characterClass = new CharacterClass();
        characterClass.setName(newCharacterClassRequest.getName());
        characterClass.setStats(stat);
        CharacterClass savedCharacterClass = characterClassRepo.save(characterClass);
        return mapToResponse(savedCharacterClass);
    }

    public ClassResponse findCharacterClassById(Long id) {
        CharacterClass characterClass = characterClassRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Class with ID: %d, was not found", id)));
        return mapToResponse(characterClass);
    }

    public List<ClassResponse> findAllCharacterClasses() {
        return characterClassRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ClassResponse mapToResponse(CharacterClass characterClass) {
        Stat stat = characterClass.getStats();
        StatsResponse statsResponse = new StatsResponse(
                stat.getId(),
                characterClass.getId(),
                stat.getStrength(),
                stat.getDexterity(),
                stat.getIntelligence(),
                stat.getConstitution(),
                stat.getWisdom(),
                stat.getCharisma()
        );
        return new ClassResponse(characterClass.getId(), characterClass.getName(), statsResponse);
    }
}