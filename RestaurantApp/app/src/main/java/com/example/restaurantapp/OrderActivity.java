package com.example.restaurantapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private ImageView selectedItemImageView;
    private TextView selectedItemTextView, selectedItemPriceView;
    private CheckBox extraCheeseCheckBox;
    private CheckBox extraBaconCheckBox;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Initialize UI components
        selectedItemImageView = findViewById(R.id.selectedItemImageView);
        selectedItemTextView = findViewById(R.id.selectedItemTextView);
        selectedItemPriceView = findViewById(R.id.selectedItemPriceTextView);
        extraCheeseCheckBox = findViewById(R.id.extraCheeseCheckBox);
        extraBaconCheckBox = findViewById(R.id.extraBaconCheckBox);
        Button proceedButton = findViewById(R.id.proceedButton);

        // Get data passed from MenuActivity
        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra("selectedItem");
        int imageResId = intent.getIntExtra("imageResId", 0);
        double selectedPrice = intent.getDoubleExtra("selectedPrice", 0.0);

        // Set the selected item's details
        selectedItemTextView.setText(selectedItem);
        selectedItemPriceView.setText("₱" + selectedPrice);
        selectedItemImageView.setImageResource(imageResId);

        // Set up the button click listener
        proceedButton.setOnClickListener(v -> {
            // Calculate the total based on selected options
            double total = calculateTotal(selectedPrice);
            Intent computationIntent = new Intent(OrderActivity.this, ComputationActivity.class);
            computationIntent.putExtra("totalPrice", total);
            startActivity(computationIntent);
        });
    }

    // Method to calculate the total price including extras
    private double calculateTotal(double basePrice) {
        double total = basePrice;

        // Check for extra cheese
        if (extraCheeseCheckBox.isChecked()) {
            total += 40.0; // Add price for extra cheese
        }

        // Check for extra bacon
        if (extraBaconCheckBox.isChecked()) {
            total += 50.0; // Add price for extra bacon
        }

        return total;
    }
}
