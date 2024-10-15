package com.example.sportszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
    private Button btnEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnEvents = findViewById(R.id.btnEvents);

        btnEvents.setOnClickListener(v -> {
            // Navigate to Events Activity
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        });
    }
}