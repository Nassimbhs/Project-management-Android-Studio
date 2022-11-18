package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button registerbtn;
    Button loginbtn;
    EditText emailEt;
    EditText passwordEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        registerbtn = findViewById(R.id.btn_register);
        loginbtn = findViewById(R.id.btn_login);
        emailEt = findViewById(R.id.datedeb);
        passwordEt = findViewById(R.id.passwordlogin);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Tachelist.class);
                startActivity(intent);

            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);

            }

        });

    }
}
