package com.example.project.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String Prenom;
    private String email;
    private String password;
    private String confirmpassword;
    private String sexe;
    private String role;

    public User() {
    }

    public User(String nom, String prenom, String email, String password, String confirmpassword, String sexe, String role) {
        this.nom = nom;
        Prenom = prenom;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.sexe = sexe;
        this.role = role;
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

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmpassword='" + confirmpassword + '\'' +
                ", sexe='" + sexe + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
