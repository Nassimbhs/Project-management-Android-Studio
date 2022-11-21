package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.project.DAO.UserDAO;
import com.example.project.Database.Mydatabase;

public class Updatedata extends AppCompatActivity {

    int id;
    EditText name1,pnom,mail,pass,cpass,se,ro;
    Button Updateuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        name1= findViewById(R.id.name2);
        pnom = findViewById(R.id.pnom2);
        mail = findViewById(R.id.mail2);
        pass = findViewById(R.id.pass2);
        cpass = findViewById(R.id.cpass2);
        se = findViewById(R.id.se2);
        ro = findViewById(R.id.ro2);
        Updateuser =findViewById(R.id.Updateuser);

        id = Integer.parseInt(getIntent().getStringExtra("id"));
        name1.setText(getIntent().getStringExtra("name1"));
        pnom.setText(getIntent().getStringExtra("pnom"));
        mail.setText(getIntent().getStringExtra("mail"));
        pass.setText(getIntent().getStringExtra("pass"));
        cpass.setText(getIntent().getStringExtra("cpass"));
        se.setText(getIntent().getStringExtra("se"));
        ro.setText(getIntent().getStringExtra("ro"));

        Updateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mydatabase db = Room.databaseBuilder(getApplicationContext(),
                        Mydatabase.class,"db").allowMainThreadQueries().build();
                UserDAO userDao = db.userDAO();
                userDao.updateById(id,name1.getText().toString()
                        ,pnom.getText().toString(),mail.getText().toString()
                        ,pass.getText().toString(),cpass.getText().toString()
                        ,se.getText().toString(),ro.getText().toString());
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });

    }

}
