package com.example.project.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Projet {

    @PrimaryKey(autoGenerate = true)
    private int pid;
    private String description;
    private String domaineactivite;
    private Date datedebut;
    private Date datefin;
    private int budget;

    public Projet(String description, String domaineactivite, Date datedebut, Date datefin, int budget  ){
        this.description=description;
        this.domaineactivite=domaineactivite;
        this.datedebut=datedebut;
        this.datefin=datefin;
        this.budget=budget;
    }

    public int getPid() {
        return pid;
    }

    public String getDescription() {
        return description;
    }

    public String getDomaineactivite() {
        return domaineactivite;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public int getBudget() {
        return budget;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDomaineactivite(String domaineactivite) {
        this.domaineactivite = domaineactivite;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "pid=" + pid +
                ", description='" + description + '\'' +
                ", domaineactivite='" + domaineactivite + '\'' +
                ", datedebut=" + datedebut +
                ", datefin=" + datefin +
                ", budget=" + budget +
                '}';
    }
}
