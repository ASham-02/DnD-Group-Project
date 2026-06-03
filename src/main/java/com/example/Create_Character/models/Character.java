package com.example.Create_Character.models;

import jakarta.persistence.*;

@Entity(name = "characters")
@Table(name = "characters", uniqueConstraints =
@UniqueConstraint(columnNames = {"element_id", "class_id", "stats_id"}))
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int height;
    private int weight;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "element_id")
    private Element element;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Class className;

    private String artwork;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stats_id")
    private Stat stat;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
