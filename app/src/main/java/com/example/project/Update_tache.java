package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.DAO.TacheDAO;
import com.example.project.DAO.UserDAO;
import com.example.project.Database.Mydatabase;

public class Update_tache extends AppCompatActivity {


    int id;
    EditText nom,datedeb,datefin;
    Button Updatetac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_tache);

            nom= findViewById(R.id.nomedit);
            datedeb = findViewById(R.id.datedebedit);
            datefin = findViewById(R.id.datefinedit);
            Updatetac =findViewById(R.id.tacedit);

            id = Integer.parseInt(getIntent().getStringExtra("id"));
        nom.setText(getIntent().getStringExtra("nom"));
            datedeb.setText(getIntent().getStringExtra("datedeb"));
            datefin.setText(getIntent().getStringExtra("datefin"));

        Updatetac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mydatabase db = Room.databaseBuilder(getApplicationContext(),
                        Mydatabase.class,"db").allowMainThreadQueries().build();
                TacheDAO tacheDAO = db.tacheDAO();
                tacheDAO.updateById(id,nom.getText().toString()
                        ,datedeb.getText().toString()
                        ,datefin.getText().toString());
                startActivity(new Intent(getApplicationContext(),Tachelist.class));
                finish();
            }
        });


    }
}