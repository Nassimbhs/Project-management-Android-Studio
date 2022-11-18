package com.example.project.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Equipe {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String nombre;

    public Equipe() {
    }

    public Equipe( String nom, String nombre) {
        this.nom = nom;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
