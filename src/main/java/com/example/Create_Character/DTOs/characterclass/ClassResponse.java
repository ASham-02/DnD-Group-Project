package com.example.Create_Character.DTOs.characterclass;

import com.example.Create_Character.DTOs.stat.StatsResponse;

public class ClassResponse {
    private Long id;
    private String name;
    private StatsResponse stats;

    public ClassResponse(Long id, String name, StatsResponse stats) {
        this.id = id;
        this.name = name;
        this.stats = stats;
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

        public StatsResponse getStats() {
            return stats;
        }

        public void setStats(StatsResponse stats) {
            this.stats = stats;
        }



}



