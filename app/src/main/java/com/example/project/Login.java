package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button registerbtn;
    Button loginbtn;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        registerbtn = findViewById(R.id.btn_register);
        loginbtn = findViewById(R.id.btn_login);
        email = findViewById(R.id.emaillogin);
        password = findViewById(R.id.passwordlogin);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);

            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("sp",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("email",email.getText().toString());
                editor.putString("password",password.getText().toString());
                editor.commit();
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
