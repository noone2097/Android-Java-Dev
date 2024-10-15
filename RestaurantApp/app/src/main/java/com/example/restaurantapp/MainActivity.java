package com.example.restaurantapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button menuButton, pButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuButton = findViewById(R.id.menuButton);
        pButton = findViewById(R.id.profileButton);

        menuButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MenuActivity.class)));
        pButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProfileActivity.class)));

    }
}
