package com.example.sportszone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class SportsStoreActivity extends AppCompatActivity {
    private CheckBox checkboxFootball, checkboxBasketball, checkboxTennisRacket, checkboxBadmintonRacket, checkboxSwimmingGoggles;
    private TextView tvTotalPrice;
    private double totalPrice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_store);

        checkboxFootball = findViewById(R.id.checkboxFootball);
        checkboxBasketball = findViewById(R.id.checkboxBasketball);
        checkboxTennisRacket = findViewById(R.id.checkboxTennis);
        checkboxBadmintonRacket = findViewById(R.id.checkboxBadminton);
        checkboxSwimmingGoggles = findViewById(R.id.checkboxGoggles);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);

        setupCheckboxListeners();

        Button btnOrder = findViewById(R.id.btnPlaceOrder);
        btnOrder.setOnClickListener(v -> placeOrder());
    }

    private void setupCheckboxListeners() {
        // Listener for Football checkbox
        checkboxFootball.setOnCheckedChangeListener((buttonView, isChecked) -> {
            double price = 699.00 * 0.90; // 10% discount applied
            updatePrice(isChecked, price);
        });

        // Listener for Basketball checkbox
        checkboxBasketball.setOnCheckedChangeListener((buttonView, isChecked) -> {
            double price = 899.00 * 0.95; // 5% discount applied
            updatePrice(isChecked, price);
        });

        // Listener for Tennis checkbox
        checkboxTennisRacket.setOnCheckedChangeListener((buttonView, isChecked) -> {
            double price = 599.00 * 0.85; // 15% discount applied
            updatePrice(isChecked, price);
        });

        // Listener for Badminton checkbox
        checkboxBadmintonRacket.setOnCheckedChangeListener((buttonView, isChecked) -> {
            double price = 499.00 * 0.92; // 8% discount applied
            updatePrice(isChecked, price);
        });

        // Listener for Swimming Goggles checkbox
        checkboxSwimmingGoggles.setOnCheckedChangeListener((buttonView, isChecked) -> {
            double price = 799.00 * 0.80; // 20% discount applied
            updatePrice(isChecked, price);
        });
    }

    private void updatePrice(boolean isChecked, double price) {
        if (isChecked) {
            totalPrice += price;
        } else {
            totalPrice -= price;
            // Prevent negative total price
            if (totalPrice < 0) {
                totalPrice = 0.0;
            }
        }
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        // Format the price to 2 decimal places
        String formattedPrice = String.format("Total Price: ₱%.2f", totalPrice);
        tvTotalPrice.setText(formattedPrice);
    }

    private void placeOrder() {
        // Check if any of the checkboxes are checked
        if (checkboxFootball.isChecked() || checkboxBasketball.isChecked() ||
                checkboxTennisRacket.isChecked() || checkboxBadmintonRacket.isChecked() ||
                checkboxSwimmingGoggles.isChecked()) {
            // If at least one item is selected, show "Order placed"
            Toast.makeText(this, "Order placed", Toast.LENGTH_SHORT).show();
        } else {
            // If no items are selected, show "Please select at least one item"
            Toast.makeText(this, "Please select at least one item", Toast.LENGTH_SHORT).show();
        }
    }
}
