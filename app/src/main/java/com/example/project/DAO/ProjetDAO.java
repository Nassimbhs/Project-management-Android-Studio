package com.example.project.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.project.Entity.Projet;

import java.util.Date;
import java.util.List;

@Dao
public interface ProjetDAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertProjet(Projet p);


    @Query("select * from Projet")
    public List<Projet> findallProjet();

    @Delete
    void deleteProjet(Projet p);


}
