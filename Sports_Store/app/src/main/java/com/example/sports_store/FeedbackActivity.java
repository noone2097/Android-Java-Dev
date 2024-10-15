package com.example.sports_store;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {
    private RadioGroup likertScaleGroup;
    private EditText feedbackEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // Initialize UI components
        likertScaleGroup = findViewById(R.id.likertScaleGroup);
        feedbackEditText = findViewById(R.id.feedbackEditText);
        Button submitButton = findViewById(R.id.submitButton);

        // Set up the button click listener
        submitButton.setOnClickListener(v -> submitFeedback());
    }

    private void submitFeedback() {
        // Get selected Likert scale value
        int selectedId = likertScaleGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        String feedbackRating = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "No rating";

        // Get feedback text
        String feedbackText = feedbackEditText.getText().toString().trim();

        // Validate feedback
        if (feedbackText.isEmpty()) {
            Toast.makeText(this, "Please enter your feedback before submitting", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate Likert scale selection
        if (selectedRadioButton == null) {
            Toast.makeText(this, "Please select a rating before submitting", Toast.LENGTH_SHORT).show();
            return;
        }

        // Display thank you message
        Toast.makeText(this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show();

        // Redirect to MainActivity
        Intent intent = new Intent(FeedbackActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Optional: finish FeedbackActivity so it can't be returned to
    }
}