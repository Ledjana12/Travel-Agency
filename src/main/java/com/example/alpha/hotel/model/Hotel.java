package com.example.alpha.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotel {@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String name;
    private String description;
    private String standard;
    private String city;


    public Hotel() {
    }
    public Hotel(String name, String description, String standard, String city) {
        this.city = city;
        this.name = name;
        this.description = description;
        this.standard = standard;

    } // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }

    public String getStandard() {
        return standard;
    }
    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}