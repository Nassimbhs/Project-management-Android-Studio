package com.example.project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EquipeViewHolder extends RecyclerView.ViewHolder{

    TextView nom;
    TextView nb;

    public EquipeViewHolder(@NonNull View itemView) {
        super(itemView);
        nom = itemView.findViewById(R.id.nomequipe);
        nb = itemView.findViewById(R.id.nombreequip);
    }
}
