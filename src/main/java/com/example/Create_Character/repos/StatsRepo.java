package com.example.Create_Character.repos;


import com.example.Create_Character.models.CharacterClass;
import com.example.Create_Character.models.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepo extends JpaRepository<Stat, Long> {
    boolean existsByCharacter(CharacterClass characterClass);
}
