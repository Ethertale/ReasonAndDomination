package io.ethertale.reasonanddominationspringdefenseproject.heroRace.model;

import jakarta.persistence.*;

@Entity
public class HeroRace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column
    private String description;
    @Column
    private int strength;
    @Column
    private int dexterity;
    @Column
    private int constitution;
    @Column
    private int intellect;
    @Column
    private int wisdom;

    public HeroRace() {
    }

    public HeroRace(int id, String name, String description, int strength, int dexterity, int constitution, int intellect, int wisdom) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intellect = intellect;
        this.wisdom = wisdom;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
}
