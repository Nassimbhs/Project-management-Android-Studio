package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.project.Database.Mydatabase;
import com.example.project.Entity.Projet;

public class Projects extends AppCompatActivity {

    AwesomeValidation awesomeValidation;
    private EditText nomEt;
    private EditText descriptionEt;
    private EditText SecteurEt;
    private EditText budgetEt;
    private Button ajout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        nomEt = findViewById(R.id.nom);
        descriptionEt = findViewById(R.id.description);
        budgetEt = findViewById(R.id.budget);
        SecteurEt = findViewById(R.id.secteur);
        ajout = findViewById(R.id.ajoutp);

        //initilisation
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //ajouter validation
        awesomeValidation.addValidation(this, R.id.nom,
                RegexTemplate.NOT_EMPTY, R.string.invalid);

        awesomeValidation.addValidation(this, R.id.description,
                RegexTemplate.NOT_EMPTY, R.string.invalid);

        awesomeValidation.addValidation(this, R.id.budget,
                RegexTemplate.NOT_EMPTY, R.string.invalid);

        awesomeValidation.addValidation(this, R.id.secteur,
                RegexTemplate.NOT_EMPTY, R.string.invalid);

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = nomEt.getText().toString();
                String description = descriptionEt.getText().toString();
                String secteur = SecteurEt.getText().toString();
                String budget = budgetEt.getText().toString();

                Projet projet = new Projet(nom,description,secteur,budget);

                Mydatabase.getDatabase(Projects.this).projetDAO().insertProjet(projet);

                Intent intent = new Intent(Projects.this, ProjectList.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),
                        "Le formulaire est validé avec succès !",
                        Toast.LENGTH_SHORT).show();

            }
        });


    }
}