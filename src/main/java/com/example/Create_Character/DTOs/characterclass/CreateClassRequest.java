package com.example.Create_Character.DTOs.characterclass;

import jakarta.validation.constraints.NotBlank;

public class CreateClassRequest {
    @NotBlank(message = "Class name is required.")
    private String name ;
    private long statsId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStatsId() {
        return statsId;
    }

    public void setStatsId(long statsId) {
        this.statsId = statsId;
    }
}
