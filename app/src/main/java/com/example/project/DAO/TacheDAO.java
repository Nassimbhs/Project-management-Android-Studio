package com.example.project.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.project.Entity.Tache;
import java.util.List;

@Dao
public interface TacheDAO {

    @Insert
    public void insertTache(Tache t);

    @Update
    public void updateTache(Tache t);


    @Query("DELETE FROM Tache WHERE id = :id")
    void deleteById(int id);

    @Query("UPDATE Tache SET id=:id,nom=:nom, datedeb =:datedeb ,datefin=:datefin")
    void updateById(int id,String nom, String datedeb,String datefin);

    @Delete
    public void deleteTache(Tache t);

    @Query("SELECT * FROM Tache")
    public List<Tache> findTache();

}
