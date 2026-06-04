package com.example.Create_Character.DTOs.element;

public class ElementResponse {

    private int id;
    private String name;
    private String nation;

    public ElementResponse() {}

    public ElementResponse(int id, String name, String nation) {
        this.id = id;
        this.name = name;
        this.nation = nation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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