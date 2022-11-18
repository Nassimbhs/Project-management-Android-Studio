package com.example.project.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project.Entity.Equipe;
import com.example.project.Entity.Projet;

import java.util.List;

@Dao
public interface EquipeDAO {


    @Insert
    public void insertEquipe(Equipe e);

    @Update
    public void updateEquipe(Equipe e);

    @Delete
    public void deleteEquipe(Equipe e);

    @Query("SELECT * FROM Equipe")
    public List<Equipe> findEquipe();

}
