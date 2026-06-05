package com.example.Create_Character.DTOs.element;

public class ElementResponse {

    private int id;
    private String element;
    private String nation;

    public ElementResponse() {}

    public ElementResponse(int id, String element, String nation) {
        this.id = id;
        this.element = element;
        this.nation = nation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String name) {
        this.element = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}