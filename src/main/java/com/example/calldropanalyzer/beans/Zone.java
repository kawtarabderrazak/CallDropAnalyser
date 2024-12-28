package com.example.calldropanalyzer.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nom de la zone (par exemple, "Zone A")
    @JsonIgnore
    @OneToMany(mappedBy = "zone")
    private List<Appel> appels; // Liste des appels dans cette zone

    private double latitude; // Latitude géographique
    private double longitude; // Longitude géographique

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
    public List<Appel> getAppels() {
        return appels;
    }

    public void setAppels(List<Appel> appels) {
        this.appels = appels;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}