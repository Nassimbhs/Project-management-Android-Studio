package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Database.Mydatabase;
import com.example.project.Entity.Projet;

import java.util.List;

public class ProjetAdapter extends RecyclerView.Adapter<ProjetViewHolder> {

    List<Projet> projetList;

    ProjetAdapter(Context context) {
        Mydatabase db = Mydatabase.getDatabase(context);
        projetList = db.projetDAO().findProjet();
    }

    @NonNull
    @Override
    public ProjetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listprojet,parent,false);
        return new ProjetViewHolder(v);

    }


    @Override
    public void onBindViewHolder(@NonNull ProjetViewHolder holder, int position) {

        Projet projet = projetList.get(position);
        holder.nom.setText(projet.getNom());
        holder.bdg.setText(projet.getDescription());
        holder.sec.setText(projet.getSecteur());
        holder.bdg.setText(projet.getBudget());

    }

    @Override
    public int getItemCount() {

        return projetList.size();

    }

}
