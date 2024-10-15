package com.example.sports_store;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] productNames;
    private final double[] productPrices;
    private final int[] imageIds;

    public ProductAdapter(Context context, String[] productNames, double[] productPrices, int[] imageIds) {
        super(context, R.layout.product_item, productNames);
        this.context = context;
        this.productNames = productNames;
        this.productPrices = productPrices;
        this.imageIds = imageIds;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        // Inflate the layout if it hasn't been done yet
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        }

        // Get references to the views
        ImageView productImage = itemView.findViewById(R.id.productImage);
        TextView productName = itemView.findViewById(R.id.productName);
        TextView productPrice = itemView.findViewById(R.id.productPrice);

        // Set the data in the views
        productName.setText(productNames[position]);
        productPrice.setText("₱" + productPrices[position]);
        productImage.setImageResource(imageIds[position]);

        // Set up item click listener
        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("selectedProduct", productNames[position]);
            intent.putExtra("selectedPrice", productPrices[position]);
            intent.putExtra("imageResId", imageIds[position]); // Pass image resource ID
            context.startActivity(intent);
        });

        return itemView;
    }
}