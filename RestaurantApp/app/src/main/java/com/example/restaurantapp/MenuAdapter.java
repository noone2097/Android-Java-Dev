package com.example.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] menuItems;
    private final double[] prices;
    private final int[] imageIds;

    public MenuAdapter(Context context, String[] menuItems, double[] prices, int[] imageIds) {
        super(context, R.layout.menu_item, menuItems);
        this.context = context;
        this.menuItems = menuItems;
        this.prices = prices;
        this.imageIds = imageIds;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        // Inflate the layout if it hasn't been done yet
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);
        }

        // Get references to the views
        ImageView menuImage = itemView.findViewById(R.id.menuImage);
        TextView menuName = itemView.findViewById(R.id.menuName);
        TextView menuPrice = itemView.findViewById(R.id.menuPrice);

        // Set the data in the views
        menuName.setText(menuItems[position]);
        menuPrice.setText("₱" + prices[position]);
        menuImage.setImageResource(imageIds[position]);

        // Set up item click listener
        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, OrderActivity.class);
            intent.putExtra("selectedItem", menuItems[position]);
            intent.putExtra("selectedPrice", prices[position]);
            intent.putExtra("imageResId", imageIds[position]); // Pass image resource ID
            context.startActivity(intent);
        });

        return itemView;
    }
}
