package com.example.project.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project.Entity.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    public void insertUser(User u);

    @Update
    public void updateUser(User u);

    @Delete
    public void deleteUser(User u);

    @Query("SELECT * FROM User")
    public List<User> findUser();

}
