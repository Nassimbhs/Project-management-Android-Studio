package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class Login extends AppCompatActivity {

    Button registerbtn;
    Button loginbtn;
    EditText emailEt;
    EditText passwordEt;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        registerbtn = findViewById(R.id.btn_register);
        loginbtn = findViewById(R.id.btn_login);
        emailEt = findViewById(R.id.emaillog);
        passwordEt = findViewById(R.id.passwordlogin);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);

            }
        });

        //initilisation
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //ajouter validation
        awesomeValidation.addValidation(this,R.id.emaillog,
                RegexTemplate.NOT_EMPTY,R.string.invalid);

        awesomeValidation.addValidation(this,R.id.passwordlogin,
                RegexTemplate.NOT_EMPTY,R.string.invalid);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()){
                    SharedPreferences sp = getSharedPreferences("sp", MODE_PRIVATE);
                    if (sp.getString("email", "nassim").equals(emailEt.getText().toString().trim())
                            && sp.getString("password", "nassim").equals(passwordEt.getText().toString().trim())) {
                        Intent intent = new Intent(Login.this, Acc.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),
                                "Addresse ou mot de passe incorrecte !",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}
