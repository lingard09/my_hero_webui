package com.example.sb_crud_webui.domain;

public class Hero {
    private Long id;
    private String name;
    private String role;
    private int health;
    private String nationality;
    private String gender;

    public Hero() {
    }

    public Hero(Long id, String name, String role, int health, String nationality, String gender) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.health = health;
        this.nationality = nationality;
        this.gender = gender;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
