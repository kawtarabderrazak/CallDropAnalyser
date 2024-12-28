package com.example.calldropanalyzer.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Appel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caller;  // Numéro de l'appelant
    private String receiver; // Numéro du récepteur
    private Date callStart; // Heure du début de l'appel
    private Date callEnd; // Heure de la fin de l'appel
    private Integer duration; // Durée de l'appel en secondes
    private boolean interrupted; // Indique si l'appel a été interrompu

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone; // Zone géographique de l'appel

    private int signalStrength; // Force du signal lors de l'appel


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public Date getCallStart() {
        return callStart;
    }
    public void setCallStart(Date callStart) {
        this.callStart = callStart;
    }
    public Date getCallEnd() {
        return callEnd;
    }

    public void setCallEnd(Date callEnd) {
        this.callEnd = callEnd;
    }

    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public int getSignalStrength() {
        return signalStrength;
    }
    public void setSignalStrength(int signalStrength) {
        this.signalStrength = signalStrength;
    }
}