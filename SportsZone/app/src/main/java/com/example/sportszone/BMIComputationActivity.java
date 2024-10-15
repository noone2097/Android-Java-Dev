package com.example.sportszone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMIComputationActivity extends AppCompatActivity {
    private EditText edtWeight, edtHeight;
    private TextView tvResult;
    private CheckBox checkboxActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicomputation);

        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        tvResult = findViewById(R.id.tvResult);
        checkboxActivity = findViewById(R.id.checkboxActivity);

        findViewById(R.id.btnCalculateBMI).setOnClickListener(v -> calculateBMI());
        findViewById(R.id.btnReset).setOnClickListener(v -> reset());
    }

    private void calculateBMI() {
        String weightStr = edtWeight.getText().toString();
        String heightStr = edtHeight.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr) / 100;
            double bmi = weight / (height * height);

            String result;
            if (bmi < 18.5) {
                result = "Underweight: " + String.format("%.2f", bmi);
            } else if (bmi < 24.9) {
                result = "Normal weight: " + String.format("%.2f", bmi);
            } else if (bmi < 29.9) {
                result = "Overweight: " + String.format("%.2f", bmi);
            } else {
                result = "Obesity: " + String.format("%.2f", bmi);
            }

            if (checkboxActivity.isChecked()) {
                result += " (You engage in regular physical activity)";
            }

            tvResult.setText(result);
        } else {
            Toast.makeText(this, "Please enter valid weight and height", Toast.LENGTH_SHORT).show();
        }
    }

    private void reset() {
        edtWeight.setText("");
        edtHeight.setText("");
        tvResult.setText("");
        checkboxActivity.setChecked(false); // Reset the checkbox
    }
}
