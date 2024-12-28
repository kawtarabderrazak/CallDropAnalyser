package com.example.calldropanalyzer.beans;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CallDropStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String zone;  // Zone géographique (ex : Rabat, Casablanca)

    @Column(nullable = false)
    private LocalDateTime timestamp;  // Date et heure de l'appel

    @Column(nullable = false)
    private boolean callDropped;  // Si l'appel a été interrompu ou non

    @Column(nullable = false)
    private double latitude;  // Latitude de l'appel

    @Column(nullable = false)
    private double longitude;  // Longitude de l'appel

    @Column(nullable = true)
    private String caller;  // Identifiant de l'appelant (facultatif)

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isCallDropped() {
        return callDropped;
    }

    public void setCallDropped(boolean callDropped) {
        this.callDropped = callDropped;
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

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    // Constructeur par défaut
    public CallDropStats() {
    }

    // Constructeur avec paramètres
    public CallDropStats(String zone, LocalDateTime timestamp, boolean callDropped, double latitude, double longitude, String caller) {
        this.zone = zone;
        this.timestamp = timestamp;
        this.callDropped = callDropped;
        this.latitude = latitude;
        this.longitude = longitude;
        this.caller = caller;
    }

    @Override
    public String toString() {
        return "CallDropStats{" +
                "id=" + id +
                ", zone='" + zone + '\'' +
                ", timestamp=" + timestamp +
                ", callDropped=" + callDropped +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", caller='" + caller + '\'' +
                '}';
    }
}
