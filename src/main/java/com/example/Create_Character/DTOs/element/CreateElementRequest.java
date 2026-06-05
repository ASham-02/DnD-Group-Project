package com.example.Create_Character.DTOs.element;

public class CreateElementRequest {

    private String element;
    private String nation;

    public CreateElementRequest() {}

    public String getName() {
        return element;
    }

    public void setName(String name) {
        this.element = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}