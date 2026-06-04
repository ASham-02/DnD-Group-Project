package com.example.Create_Character.services;

import com.example.Create_Character.models.Element;
import com.example.Create_Character.repos.ElementRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementService {

    private final ElementRepo elementRepo;

    public ElementService(ElementRepo elementRepo) {
        this.elementRepo = elementRepo;
    }

    public List<Element> getAllElements() {
        return elementRepo.findAll();
    }

    public Element getElementById(int id) {
        return elementRepo.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Element not found"));
    }
}