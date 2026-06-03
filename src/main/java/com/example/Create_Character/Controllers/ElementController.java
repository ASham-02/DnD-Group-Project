package com.example.Create_Character.Controllers;

import com.example.Create_Character.services.ElementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Element;
import java.util.List;

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
}