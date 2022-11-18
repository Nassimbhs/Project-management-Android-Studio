package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.project.DAO.UserDAO;
import com.example.project.Database.Mydatabase;
import com.example.project.Entity.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    List<User> usersList;

    UserAdapter adapter = this;

    UserAdapter(Context context) {
        Mydatabase db = Mydatabase.getDatabase(context);
        usersList = db.userDAO().findUser();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listuser,parent,false);
        return new UserViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        User user = usersList.get(position);
        holder.idt.setText(String.valueOf(usersList.get(position).getId()));
        holder.nom.setText(user.getNom());
        holder.email.setText(user.getEmail());

        holder.deletebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mydatabase db = Room.databaseBuilder(holder.idt.getContext(),
                        Mydatabase.class, "db").allowMainThreadQueries().build();
                UserDAO userDao = db.userDAO();
                // this is to delete the record from room database
                userDao.deleteById(usersList.get(position).getId());
                // this is to delete the record from Array List which is the source of recview data
                usersList.remove(position);

                //update the fresh list of ArrayList data to recview
                notifyDataSetChanged();

            }
        });
        holder.editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new Intent(holder.editbt.getContext(),Updatedata.class));
                intent.putExtra("id",String.valueOf(usersList.get(position).getId()));
                intent.putExtra("name1",usersList.get(position).getNom());
                intent.putExtra("pnom",usersList.get(position).getPrenom());
                intent.putExtra("mail",usersList.get(position).getEmail());
                intent.putExtra("pass",usersList.get(position).getPassword());
                intent.putExtra("cpass",usersList.get(position).getConfirmpassword());
                intent.putExtra("se",usersList.get(position).getSexe());
                intent.putExtra("ro",usersList.get(position).getRole());
                holder.editbt.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return usersList.size();

    }

    public UserAdapter likadapter(UserAdapter adapter){
        this.adapter = adapter;
        return this;
    }

}