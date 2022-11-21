package com.example.project;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TacheViewHolder extends RecyclerView.ViewHolder{
    TextView nom;
    TextView datedeb;
    TextView datefin;
    Button deletebt;
    Button editbt;
    TextView idt;

    public TacheViewHolder(@NonNull View itemView) {
        super(itemView);

        idt = itemView.findViewById(R.id.idtac);
        nom = itemView.findViewById(R.id.nomtache);
        datedeb = itemView.findViewById(R.id.datedebtac);
        datefin = itemView.findViewById(R.id.datefintache);
        deletebt = itemView.findViewById(R.id.deletetac);
        editbt = itemView.findViewById(R.id.edittac);
    }
}
