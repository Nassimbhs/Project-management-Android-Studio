package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.project.DAO.UserDAO;
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

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listtache, parent, false);
        return new TacheViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull TacheViewHolder holder, int position) {

        Tache tache = tacheList.get(position);
        holder.idt.setText(String.valueOf(tacheList.get(position).getId()));
        holder.nom.setText(tache.getNom());
        holder.datedeb.setText(tache.getDatedeb());
        holder.datefin.setText(tache.getDatefin());

        holder.deletebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mydatabase db = Room.databaseBuilder(holder.idt.getContext(),
                        Mydatabase.class, "db").allowMainThreadQueries().build();
                UserDAO userDao = db.userDAO();
                // this is to delete the record from room database
                userDao.deleteById(tacheList.get(position).getId());
                // this is to delete the record from Array List which is the source of recview data
                tacheList.remove(position);

                //update the fresh list of ArrayList data to recview
                notifyDataSetChanged();

            }
        });

        holder.editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new Intent(holder.editbt.getContext(), Update_tache.class));
                intent.putExtra("id", String.valueOf(tacheList.get(position).getId()));
                intent.putExtra("nom", tacheList.get(position).getNom());
                intent.putExtra("datedeb", tacheList.get(position).getDatedeb());
                intent.putExtra("datefin", tacheList.get(position).getDatefin());
                holder.editbt.getContext().startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {

        return tacheList.size();

    }

}
