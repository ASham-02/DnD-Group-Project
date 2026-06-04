package com.example.Create_Character.DTOs.character;

public class CreateCharacterRequest {

    private Long userId;
    private String name;
    private int age;
    private Long classId;
    private Long elementId;
    private String bio;
    private String artworkUrl;


    public Long getUserId() { return userId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public Long getClassId() { return classId; }
    public Long getElementId() { return elementId; }
    public String getBio() { return bio; }
    public String getArtworkUrl() { return artworkUrl; }


    public void setUserId(Long userId) { this.userId = userId; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setClassId(Long classId) { this.classId = classId; }
    public void setElementId(Long elementId) { this.elementId = elementId; }
    public void setBio(String bio) { this.bio = bio; }
    public void setArtworkUrl(String artworkUrl) { this.artworkUrl = artworkUrl; }
}