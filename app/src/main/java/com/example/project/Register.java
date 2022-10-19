package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.project.Database.Mydatabase;
import com.example.project.Entity.User;

public class Register extends AppCompatActivity {

    AwesomeValidation awesomeValidation;
    private EditText nomEt;
    private EditText prenomEt;
    private EditText emailEt;
    private EditText passwordEt;
    private EditText confirmpasswordEt;
    private Button registerbtn;
    private Button loginbtn;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private RadioGroup radioGrouptype;
    private RadioButton radioButtontype;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        nomEt = findViewById(R.id.nom);
        prenomEt = findViewById(R.id.emaillogin);
        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);
        confirmpasswordEt = findViewById(R.id.confirmpassword);
        registerbtn = findViewById(R.id.register_btn);
        loginbtn = findViewById(R.id.login);
        radioGroup = findViewById(R.id.selectedid);
        radioButton = findViewById(R.id.homme);
        radioButton = findViewById(R.id.femme);
        radioGrouptype = findViewById(R.id.selectedidType);
        radioButtontype = findViewById(R.id.admin);
        radioButtontype = findViewById(R.id.employee);

        //initilisation
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //ajouter validation
        awesomeValidation.addValidation(this,R.id.nom,
                RegexTemplate.NOT_EMPTY,R.string.invalid);

        awesomeValidation.addValidation(this,R.id.emaillogin,
                RegexTemplate.NOT_EMPTY,R.string.invalid);

        awesomeValidation.addValidation(this,R.id.email,
                RegexTemplate.NOT_EMPTY,R.string.invalid);

        awesomeValidation.addValidation(this,R.id.password,
                RegexTemplate.NOT_EMPTY,R.string.invalid);

        awesomeValidation.addValidation(this,R.id.confirmpassword,
                RegexTemplate.NOT_EMPTY,R.string.invalid);

        awesomeValidation.addValidation(this,R.id.password,R.id.confirmpassword,R.string.invalid_password);

        registerbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    if (awesomeValidation.validate()){

                    String nom = nomEt.getText().toString();
                    String prenom = prenomEt.getText().toString();
                    String email = emailEt.getText().toString();
                    String password = passwordEt.getText().toString();
                    String confirmpassword = confirmpasswordEt.getText().toString();

                    //Récupérer bouton radio
                    int selectedid = radioGroup.getCheckedRadioButtonId();
                    radioButton = findViewById(selectedid);
                    String sexe = radioButton.getText().toString();

                    //Récupérer bouton radio
                        int selectedidType = radioGrouptype.getCheckedRadioButtonId();
                        radioButtontype = findViewById(selectedidType);
                        String role = radioButtontype.getText().toString();

                        User user = new User(nom, prenom, email, password, confirmpassword,sexe,role);

                        Mydatabase.getDatabase(Register.this).userDAO().insertUser(user);

                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);

                    Toast.makeText(getApplicationContext(),
                            "Le formulaire est validé avec succès !",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

    }
}
