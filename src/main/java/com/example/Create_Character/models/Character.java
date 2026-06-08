package com.example.Create_Character.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "characters")
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int age;
    private int height;
    private int weight;
    private String artwork;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private CharacterClass characterClass;

    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;

    public long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }
    public String getArtwork() { return artwork; }
    public User getUser() { return user; }
    public CharacterClass getCharacterClass() { return characterClass; }
    public Element getElement() { return element; }

    // Setters
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setHeight(int height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setArtwork(String artwork) { this.artwork = artwork; }
    public void setUser(User user) { this.user = user; }
    public void setCharacterClass(CharacterClass characterClass) { this.characterClass = characterClass; }
    public void setElement(Element element) { this.element = element; }
}

