package com.example.sports_store;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ComputationActivity extends AppCompatActivity {

    private TextView totalTextView, thankYouTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computation);

        // Initialize UI components
        totalTextView = findViewById(R.id.totalTextView);
        thankYouTextView = findViewById(R.id.thankYouTextView);
        Button placeOrderButton = findViewById(R.id.placeOrderButton);

        // Get total price passed from OrderActivity
        double totalPrice = getIntent().getDoubleExtra("totalPrice", 0);
        totalTextView.setText(String.format("Total: ₱%.2f", totalPrice));

        // Set up the button click listener
        placeOrderButton.setOnClickListener(v -> {
            Toast.makeText(ComputationActivity.this, "Order placed successfully!", Toast.LENGTH_SHORT).show();
            thankYouTextView.setVisibility(View.VISIBLE);
            Intent intent = new Intent(ComputationActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
