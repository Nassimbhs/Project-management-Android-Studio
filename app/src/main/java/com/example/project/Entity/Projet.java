package com.example.project.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Projet {

    private String budget;
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String description;
    private String secteur;

    public Projet() {
    }

    public Projet(String nom, String description, String secteur, String budget) {
        this.nom = nom;
        this.description = description;
        this.secteur = secteur;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", secteur='" + secteur + '\'' +
                ", budget='" + budget + '\'' +
                '}';
    }
}
