package com.example.Create_Character.DTOs.element;

public class CreateElementRequest {

    private String name;
    private String nation;

    public CreateElementRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}