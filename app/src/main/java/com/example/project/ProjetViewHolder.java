package com.example.project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjetViewHolder extends RecyclerView.ViewHolder{

    TextView nom;
    TextView desc;
    TextView sec;
    TextView bdg;

    public ProjetViewHolder(@NonNull View itemView) {
        super(itemView);
        nom = itemView.findViewById(R.id.nomprojet);
        desc = itemView.findViewById(R.id.descprojet);
        sec = itemView.findViewById(R.id.sectprojet);
        bdg = itemView.findViewById(R.id.budprojet);
    }

}
