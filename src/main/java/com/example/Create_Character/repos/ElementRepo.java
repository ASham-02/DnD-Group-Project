package com.example.Create_Character.repos;

import com.example.Create_Character.models.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepo extends JpaRepository<Element, Integer> {
}