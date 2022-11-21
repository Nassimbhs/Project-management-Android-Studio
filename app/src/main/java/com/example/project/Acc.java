package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Acc extends AppCompatActivity {

    Button Utilisateurs;
    Button Taches;
    Button Equipe;
    Button Projets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        Taches = findViewById(R.id.Taches);
        Equipe= findViewById(R.id.Equipe);
        Utilisateurs= findViewById(R.id.Utilisateurs);
        Projets= findViewById(R.id.Projets);

        Utilisateurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Acc.this, MainActivity.class);
                startActivity(intent);
            }
        });


        Equipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Acc.this, Equipeprojet.class);
                startActivity(intent);
            }
        });


        Projets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Acc.this, Projects.class);
                startActivity(intent);
            }
        });


        Taches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Acc.this, Taches.class);
                startActivity(intent);
            }
        });
    }
}