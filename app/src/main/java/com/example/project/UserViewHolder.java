package com.example.project;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView nom;
    TextView email;
    ImageView imageView;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageview);
        nom = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.emailuser);

    }
}
