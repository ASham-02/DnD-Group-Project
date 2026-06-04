package com.example.Create_Character.DTOs.characterclass;

public class ClassResponse {
    private Long id;
    private String name;
    private Long statsId;

    public ClassResponse(Long id, String name, Long statsId){
        this.id = id;
        this.name = name;
        this.statsId = statsId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStatsId() {
        return statsId;
    }

    public void setStatsId(Long statsId) {
        this.statsId = statsId;
    }
}
