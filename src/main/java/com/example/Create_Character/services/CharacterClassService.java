package com.example.Create_Character.services;

import com.example.Create_Character.DTOs.characterclass.ClassResponse;
import com.example.Create_Character.DTOs.characterclass.CreateClassRequest;
import com.example.Create_Character.models.CharacterClass;
import com.example.Create_Character.repos.CharacterClassRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class CharacterClassService {

    private final CharacterClassRepo characterClassRepo;

    public CharacterClassService (CharacterClassRepo characterClassRepo) {
        this.characterClassRepo = characterClassRepo;
    }

    public ClassResponse addCharacterClass(CreateClassRequest newCharacterClassRequest){
        //if class already exists do not create?
        if(characterClassRepo.existsByName(newCharacterClassRequest.getName())) {
            throw new IllegalArgumentException("This class is already in" + " use!");
        }
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName(newCharacterClassRequest.getName());
        characterClass.setStatsId(newCharacterClassRequest.getStatsId());
        CharacterClass savedCharacterClass = characterClassRepo.save(characterClass);
        return mapToResponse(savedCharacterClass);
    }


    public ClassResponse findCharacterClassById(Long id){
        CharacterClass characterClass =
                characterClassRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Class with ID: %d, was not found", id)));
        return mapToResponse(characterClass);
    }
    public List<ClassResponse> findAllCharacterClasses() {
        return characterClassRepo.findAll().stream().map(this::mapToResponse).toList();
    }

    private ClassResponse mapToResponse (CharacterClass characterClass){
        return new ClassResponse(characterClass.getId(), characterClass.getName(), characterClass.getStatsId());

    }
}
