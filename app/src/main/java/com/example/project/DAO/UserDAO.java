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

    @Query("SELECT EXISTS(SELECT * FROM User WHERE id = :userId)")
    Boolean is_exist(int userId);

    @Query("DELETE FROM User WHERE id = :id")
    void deleteById(int id);

    @Query("UPDATE User SET id=:id, nom =:name1 ,prenom=:pnom, email=:mail ,password=:pass,confirmpassword=:cpass,sexe=:se,role=:ro")
    void updateById(int id,String name1,String pnom,String mail,String pass,String cpass,String se,String ro);

    @Update
    void updateUser(User u);

    @Query("SELECT * FROM User")
    public List<User> findUser();

}
