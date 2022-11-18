package com.example.project.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tache {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String datedeb;
    private String datefin;

    public Tache() {
    }

    public Tache(String nom, String datedeb, String datefin) {
        this.nom = nom;
        this.datedeb = datedeb;
        this.datefin = datefin;
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

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", datedeb='" + datedeb + '\'' +
                ", datefin='" + datefin + '\'' +
                '}';
    }
}
