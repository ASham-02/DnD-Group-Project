package com.example.Create_Character.Controllers;

import com.example.Create_Character.models.Character;
import com.example.Create_Character.services.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = "http://localhost:5173")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }


    @GetMapping("/user/{userId}")
    public List<Character> getAll(@PathVariable Long userId) {
        return service.getAll(userId);
    }


    @GetMapping("/{id}")
    public Character getOne(@PathVariable Long id) {
        return service.getOne(id);
    }


    @PostMapping
    public Character create(@RequestBody Character character) {
        return service.create(character);
    }


    @PutMapping("/{id}")
    public Character update(@PathVariable Long id, @RequestBody Character character) {
        return service.update(id, character);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}