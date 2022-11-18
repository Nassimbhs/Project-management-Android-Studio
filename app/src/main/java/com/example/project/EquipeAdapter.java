package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Database.Mydatabase;
import com.example.project.Entity.Equipe;

import java.util.List;

public class EquipeAdapter extends RecyclerView.Adapter<EquipeViewHolder> {
    List<Equipe> equipeList;

    EquipeAdapter(Context context) {
        Mydatabase db = Mydatabase.getDatabase(context);
        equipeList = db.equipeDAO().findEquipe();
    }

    @NonNull
    @Override
    public EquipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listequipe,parent,false);
        return new EquipeViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull EquipeViewHolder holder, int position) {

        Equipe equipe = equipeList.get(position);
        holder.nom.setText(equipe.getNom());
        holder.nb.setText(equipe.getNombre());

    }

    @Override
    public int getItemCount() {

        return equipeList.size();

    }

}
