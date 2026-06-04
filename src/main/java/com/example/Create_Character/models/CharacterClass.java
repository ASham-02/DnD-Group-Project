package com.example.Create_Character.models;

import jakarta.persistence.*;



@Entity(name = "classes")
@Table(name = "classes")
public class CharacterClass {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Will need to change to @OnetoOne with relationship to Stat
    private Long statsId;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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


