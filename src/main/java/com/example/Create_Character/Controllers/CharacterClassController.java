package com.example.Create_Character.Controllers;

import com.example.Create_Character.DTOs.characterclass.ClassResponse;
import com.example.Create_Character.DTOs.characterclass.CreateClassRequest;
import com.example.Create_Character.services.CharacterClassService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/characterClass")
public class CharacterClassController {
    private final CharacterClassService characterClassService;

    public CharacterClassController(CharacterClassService characterClassService){
        this.characterClassService = characterClassService;
    }

    //Get all character classes
    @GetMapping
    public ResponseEntity<List<ClassResponse>> getAllCharacterClasses() {
        return ResponseEntity.ok(characterClassService.findAllCharacterClasses());
    }

    //get a characterclass by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClassResponse> getCharacterClassById(@PathVariable @Min(1) Long id){
        return ResponseEntity.ok(characterClassService.findCharacterClassById(id));
    }

    //create a characterclass

    @PostMapping
    public ResponseEntity<ClassResponse> createCharacterClass(@Valid @RequestBody CreateClassRequest newCharacterClass) {
        ClassResponse ClassResponse = characterClassService.addCharacterClass(newCharacterClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClassResponse);
    }

//    // delete a characterclass
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCharacterClass(@PathVariable @Min(1) Long id) {
//        characterClassService.deleteCharacterClass(id);
//        return ResponseEntity.noContent().build();
//    }
}
