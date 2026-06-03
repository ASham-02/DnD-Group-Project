package com.example.Create_Character.DTOs.stat;

import com.example.Create_Character.models.CharacterClass;

public class StatsResponse {
    private Long id;
    private CharacterClass characterClassName;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int constitution;
    private int wisdom;
    private int charisma;

    public StatsResponse(Long id, CharacterClass characterClassName, int strength, int dexterity, int intelligence, int constitution, int wisdom, int charisma) {
        this.id = id;
        this.characterClassName = characterClassName;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CharacterClass getCharacterClassName() {
        return characterClassName;
    }

    public void setCharacterClassName(CharacterClass characterClassName) {
        this.characterClassName = characterClassName;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
}
