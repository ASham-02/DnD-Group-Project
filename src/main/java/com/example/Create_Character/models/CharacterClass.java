package com.example.Create_Character.models;

import jakarta.persistence.*;



@Entity(name = "classes")
@Table(name = "classes")
public class CharacterClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Will need to change to @OnetoOne with relationship to Stat
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stats_id")
  private Stat stats;
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

    public Stat getStats() {
        return stats;
    }

    public void setStats(Stat stats) {
        this.stats = stats;
    }
}


