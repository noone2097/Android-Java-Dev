package com.example.touristspotsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button spotsButton, souvenirButton, feedbackButton, aboutButton, contactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spotsButton = findViewById(R.id.spotsButton);
        souvenirButton = findViewById(R.id.souvenirButton);
        feedbackButton = findViewById(R.id.feedbackButton);
        aboutButton = findViewById(R.id.aboutButton);
        contactButton = findViewById(R.id.contactButton);

        spotsButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TouristSpotsListActivity.class)));
        souvenirButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SouvenirListActivity.class)));
        feedbackButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FeedbackActivity.class)));
        aboutButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AboutActivity.class)));
        contactButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ContactUsActivity.class)));
    }
}
