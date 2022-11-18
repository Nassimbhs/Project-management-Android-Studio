package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.project.Database.Mydatabase;
import com.example.project.Entity.Equipe;
import com.example.project.Entity.Tache;

public class Equipeprojet extends AppCompatActivity {

    AwesomeValidation awesomeValidation;
    private EditText nomeT;
    private EditText nombreEt;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipeprojet);

        nomeT = findViewById(R.id.nomequip);
        nombreEt = findViewById(R.id.nombreequip);
        button = findViewById(R.id.ajoutequip);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nom = nomeT.getText().toString();
                String nombre = nombreEt.getText().toString();


                Equipe equipe = new Equipe(nom, nombre);

                Mydatabase.getDatabase(Equipeprojet.this).equipeDAO().insertEquipe(equipe);

                Intent intent = new Intent(Equipeprojet.this, Login.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),
                        "Le formulaire est validé avec succès !",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}