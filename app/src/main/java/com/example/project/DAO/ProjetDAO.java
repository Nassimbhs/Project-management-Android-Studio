package com.example.project.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.project.Entity.Projet;

import java.util.List;

@Dao
public interface ProjetDAO {

    @Insert
    public void insertProjet(Projet p);

    @Update
    public void updateProjet(Projet p);

    @Delete
    public void deleteProjet(Projet p);

    @Query("SELECT * FROM Projet")
    public List<Projet> findProjet();

}