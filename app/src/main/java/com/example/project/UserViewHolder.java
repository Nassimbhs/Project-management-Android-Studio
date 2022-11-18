package com.example.project;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.nio.Buffer;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView nom;
    TextView email;
    TextView idt;
    Button deletebt;
    Button editbt;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        nom = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.emailuser);
        idt = itemView.findViewById(R.id.iduser);
        deletebt = itemView.findViewById(R.id.deleteuser);
        editbt = itemView.findViewById(R.id.edituser);

    }
}
