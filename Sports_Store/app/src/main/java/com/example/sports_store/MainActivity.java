package com.example.sports_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button menuButton, pButton, feedBackButton, aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuButton = findViewById(R.id.menuButton);
        pButton = findViewById(R.id.profileButton);
        feedBackButton = findViewById(R.id.feedBackButton);
        aboutButton = findViewById(R.id.aboutButton);

        menuButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProductActivity.class)));
        pButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProfileActivity.class)));
        feedBackButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FeedbackActivity.class)));
        aboutButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AboutActivity.class)));
    }
}