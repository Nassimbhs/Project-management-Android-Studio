package com.example.project.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.project.DAO.EquipeDAO;
import com.example.project.DAO.ProjetDAO;
import com.example.project.DAO.TacheDAO;
import com.example.project.DAO.UserDAO;
import com.example.project.Entity.Equipe;
import com.example.project.Entity.Tache;
import com.example.project.Entity.User;
import com.example.project.Entity.Projet;


@Database(entities = {User.class, Projet.class, Tache.class, Equipe.class},version = 1,exportSchema = false)
public abstract class Mydatabase extends RoomDatabase {

    private static Mydatabase instance;

    public abstract UserDAO userDAO();
    public abstract ProjetDAO projetDAO();
    public abstract TacheDAO tacheDAO();
    public abstract EquipeDAO equipeDAO();

    public static Mydatabase getDatabase(Context ctx)
    {
        if(instance == null){
            instance = Room.databaseBuilder(ctx.getApplicationContext(),Mydatabase.class,"db")
                    .allowMainThreadQueries().build();
        }

        return instance;
    }

}
