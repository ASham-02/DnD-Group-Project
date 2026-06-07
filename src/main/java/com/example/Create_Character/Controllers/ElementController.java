package com.example.Create_Character.Controllers;

import com.example.Create_Character.models.Element;
import com.example.Create_Character.services.ElementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/elements")
public class ElementController {

    private final ElementService elementService;

    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    @GetMapping
    public ResponseEntity<List<Element>> getAllElements() {
        return ResponseEntity.ok(elementService.getAllElements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Element> getElementById(@PathVariable Long id) {
        return ResponseEntity.ok(elementService.getElementById(id));
    }

    // Code to create new element
    @PostMapping
    public Element createElement(@RequestBody Element element) {
        return elementService.createElement(element);
    }
}