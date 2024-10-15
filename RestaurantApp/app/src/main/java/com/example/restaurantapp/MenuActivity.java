package com.example.restaurantapp;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private ListView menuListView;
    private String[] menuItems = {
            "Spaghetti Carbonara",
            "Cheeseburger",
            "Caesar Salad",
            "Margherita Pizza",
            "Grilled Chicken",
            "Vegetable Stir Fry",
            "Chocolate Cake",
            "Ice Cream Sundae"
    };
    private double[] prices = {350.0, 250.0, 180.0, 400.0, 520.0, 220.0, 120.0, 150.0};
    private int[] imageIds = {
            R.drawable.spaghetti_carbonara,
            R.drawable.cheeseburger,
            R.drawable.caesar_salad,
            R.drawable.margherita_pizza,
            R.drawable.grilled_chicken,
            R.drawable.vegetable_stir_fry,
            R.drawable.chocolate_cake,
            R.drawable.ice_cream_sundae
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuListView = findViewById(R.id.menuListView);

        MenuAdapter adapter = new MenuAdapter(this, menuItems, prices, imageIds);
        menuListView.setAdapter(adapter);
    }
}
