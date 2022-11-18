package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.project.Database.Mydatabase;
import com.example.project.Entity.User;
import com.example.project.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView email;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("sp", MODE_PRIVATE);
        setTitle("Hello " + sp.getString("username", "Nassim"));


        recyclerView = findViewById(R.id.userview);
        Mydatabase db = Mydatabase.getDatabase(MainActivity.this);
//        List<Article> articleList = db.articleDAO().findArticles();
        UserAdapter adapter = new UserAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

    }

}