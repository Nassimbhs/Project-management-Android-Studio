package com.example.project.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.project.DAO.ProjetDAO;
import com.example.project.Entity.Projet;


@Database(entities = {Projet.class},version = 1,exportSchema = false)
public abstract class ProjetDatabase extends RoomDatabase {

    public static final  String DB_name="db";
    private static ProjetDatabase instance;

    public static synchronized  ProjetDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(), ProjetDatabase.class, DB_name)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return  instance;
    }

    public abstract ProjetDAO projetDAO();
}
