package com.example.sports_store;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    private ListView productListView;
    private String[] productItems = {
            "Basketball",
            "Soccer Ball",
            "Running Shoes",
            "Yoga Mat",
            "Tennis Racket"
    };
    private double[] prices = {800.0, 600.0, 2500.0, 450.0, 1500.0};
    private int[] imageIds = {
            R.drawable.basketball,
            R.drawable.soccer_ball,
            R.drawable.running_shoes,
            R.drawable.yoga_mat,
            R.drawable.tennis_racket
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productListView = findViewById(R.id.productListView);

        ProductAdapter adapter = new ProductAdapter(this, productItems, prices, imageIds);
        productListView.setAdapter(adapter);
    }
}
