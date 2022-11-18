package com.example.project;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TacheViewHolder extends RecyclerView.ViewHolder{
    TextView nom;
    TextView datedeb;
    TextView datefin;
    public TacheViewHolder(@NonNull View itemView) {
        super(itemView);

        nom = itemView.findViewById(R.id.nomtache);
        datedeb = itemView.findViewById(R.id.datedeb);
        datefin = itemView.findViewById(R.id.datefin);

    }
}
