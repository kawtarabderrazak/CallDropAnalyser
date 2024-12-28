package com.example.calldropanalyzer.beans;



import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Rapport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Titre du rapport
    private String content; // Contenu du rapport
    private Date dateCreated; // Date de création du rapport

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Operateur createdBy; // L'opérateur qui a généré le rapport

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Operateur getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Operateur createdBy) {
        this.createdBy = createdBy;
    }
}
