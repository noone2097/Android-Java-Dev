package com.example.sportszone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bmiButton = findViewById(R.id.btnBMI);
        Button sportsStoreButton = findViewById(R.id.btnSportsStore);
        Button eventsButton = findViewById(R.id.btnUpcomingEvents);
        Button newsButton = findViewById(R.id.btnSportNews);
        Button feedbackButton = findViewById(R.id.btnFeedback);
        Button aboutButton = findViewById(R.id.btnAbout);

        bmiButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BMIComputationActivity.class);
            startActivity(intent);
        });
        sportsStoreButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SportsStoreActivity.class);
            startActivity(intent);
        });
        eventsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, UpcomingEventsActivity.class);
            startActivity(intent);
        });
        newsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SportNewsActivity.class);
            startActivity(intent);
        });
        feedbackButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
            startActivity(intent);
        });
        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });

    }
}
