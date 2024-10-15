package com.example.sports_store;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView selectedItemImageView;
    private TextView selectedItemTextView, selectedItemPriceView;
    private CheckBox extraWarrantyCheckBox; // Example of an extra option
    private CheckBox giftWrapCheckBox; // Another extra option

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Initialize UI components
        selectedItemImageView = findViewById(R.id.selectedItemImageView);
        selectedItemTextView = findViewById(R.id.selectedItemTextView);
        selectedItemPriceView = findViewById(R.id.selectedItemPriceTextView);
        extraWarrantyCheckBox = findViewById(R.id.extraWarrantyCheckBox);
        giftWrapCheckBox = findViewById(R.id.giftWrapCheckBox);
        Button proceedButton = findViewById(R.id.proceedButton);

        // Get data passed from ProductActivity
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
            Toast.makeText(this, "Total Price: ₱" + total, Toast.LENGTH_SHORT).show();
            Intent computationIntent = new Intent(ProductDetailActivity.this, ComputationActivity.class);
            computationIntent.putExtra("totalPrice", total);
            startActivity(computationIntent);
        });
    }

    // Method to calculate the total price including extras
    private double calculateTotal(double basePrice) {
        double total = basePrice;

        // Check for extra warranty
        if (extraWarrantyCheckBox.isChecked()) {
            total += 100.0; // Add price for extra warranty
        }

        // Check for gift wrap
        if (giftWrapCheckBox.isChecked()) {
            total += 50.0; // Add price for gift wrap
        }

        return total;
    }
}
