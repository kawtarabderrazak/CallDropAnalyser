package com.example.calldropanalyzer.beans;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Operateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nom de l'opérateur
    private String email; // Email de l'opérateur

    @OneToMany(mappedBy = "createdBy")
    private List<Rapport> rapports; // Liste des rapports générés par l'opérateur

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rapport> getRapports() {
        return rapports;
    }

    public void setRapports(List<Rapport> rapports) {
        this.rapports = rapports;
    }
}
