package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Database.Mydatabase;
import com.example.project.Entity.Tache;

import java.util.List;

public class TacheAdapter  extends RecyclerView.Adapter<TacheViewHolder> {

    List<Tache> tacheList;

    TacheAdapter(Context context) {
        Mydatabase db = Mydatabase.getDatabase(context);
        tacheList = db.tacheDAO().findTache();
    }

    @NonNull
    @Override
    public TacheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listprojet,parent,false);
        return new TacheViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull TacheViewHolder holder, int position) {

        Tache tache = tacheList.get(position);
        holder.nom.setText(tache.getNom());
        holder.datedeb.setText(tache.getDatedeb());
        holder.datefin.setText(tache.getDatefin());


    }

    @Override
    public int getItemCount() {

        return tacheList.size();

    }

}
