package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.project.Database.Mydatabase;
import com.example.project.Entity.Tache;

public class Taches extends AppCompatActivity {

    AwesomeValidation awesomeValidation;
    private EditText nomEt;
    private EditText datedebEt;
    private EditText datefinEt;
    private Button ajouttac;
    private Button vtace;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tache);


        nomEt = findViewById(R.id.nomtac);
        datedebEt = findViewById(R.id.emaillog);
        datefinEt = findViewById(R.id.datefin);
        ajouttac = findViewById(R.id.ajouttac);
        vtace = findViewById(R.id.vtace);

        vtace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Taches.this, Tachelist.class);
                startActivity(intent);
            }
        });
        ajouttac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String nom = nomEt.getText().toString();
                    String datedeb = datedebEt.getText().toString();
                    String datefin = datefinEt.getText().toString();

                    Tache tache = new Tache(nom,datedeb,datefin);

                    Mydatabase.getDatabase(Taches.this).tacheDAO().insertTache(tache);

                    Intent intent = new Intent(Taches.this, Tachelist.class);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),
                            "Le formulaire est validé avec succès !",
                            Toast.LENGTH_SHORT).show();
                }

        });

    }

}

