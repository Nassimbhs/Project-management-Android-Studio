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
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tache);


        nomEt = findViewById(R.id.nomtac);
        datedebEt = findViewById(R.id.datedeb);
        datefinEt = findViewById(R.id.datefin);
        button = findViewById(R.id.ajouttac);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String nom = nomEt.getText().toString();
                    String datedeb = datedebEt.getText().toString();
                    String datefin = datefinEt.getText().toString();

                    Tache tache = new Tache(nom,datedeb,datefin);

                    Mydatabase.getDatabase(Taches.this).tacheDAO().insertTache(tache);

                    Intent intent = new Intent(Taches.this, Login.class);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),
                            "Le formulaire est validé avec succès !",
                            Toast.LENGTH_SHORT).show();
                }

        });

    }

}

