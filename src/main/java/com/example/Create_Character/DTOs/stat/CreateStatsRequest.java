package com.example.Create_Character.DTOs.stat;

import com.example.Create_Character.models.CharacterClass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateStatsRequest {
    @NotBlank(message = "A class should be provided")
    private String characterClassName;

    @NotNull(message = "Stat Sheet should have strength value")
    @Min(value = 1, message = "Each stat should not be smaller than 1")
    @Max(value = 10, message = "Each stat caps at 10")
    private int strength;

    @NotNull(message = "Stat Sheet should have dexterity value")
    @Min(value = 1, message = "Each stat should not be smaller than 1")
    @Max(value = 10, message = "Each stat caps at 10")
    private int dexterity;

    @NotNull(message = "Stat Sheet should have intelligence value")
    @Min(value = 1, message = "Each stat should not be smaller than 1")
    @Max(value = 10, message = "Each stat caps at 10")
    private int intelligence;

    @NotNull(message = "Stat Sheet should have constitution value")
    @Min(value = 1, message = "Each stat should not be smaller than 1")
    @Max(value = 10, message = "Each stat caps at 10")
    private int constitution;

    @NotNull(message = "Stat Sheet should have wisdom value")
    @Min(value = 1, message = "Each stat should not be smaller than 1")
    @Max(value = 10, message = "Each stat caps at 10")
    private int wisdom;

    @NotNull(message = "Stat Sheet should have charisma value")
    @Min(value = 1, message = "Each stat should not be smaller than 1")
    @Max(value = 10, message = "Each stat caps at 10")
    private int charisma;

    //Change to grab the name from the class
    public String getCharacterClass() {
        return characterClassName;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClassName = characterClass;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
