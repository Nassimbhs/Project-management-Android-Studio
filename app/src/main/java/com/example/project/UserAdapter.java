package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Database.Mydatabase;
import com.example.project.Entity.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    List<User> usersList;

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
        holder.nom.setText(user.getNom());
        holder.email.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {

        return usersList.size();

    }

}
