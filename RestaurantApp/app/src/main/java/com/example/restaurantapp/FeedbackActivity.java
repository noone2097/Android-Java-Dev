package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    private EditText feedbackEditText;
    private RadioGroup ratingRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        feedbackEditText = findViewById(R.id.feedbackEditText);
        ratingRadioGroup = findViewById(R.id.ratingRadioGroup);
        Button submitFeedbackButton = findViewById(R.id.submitFeedbackButton);

        submitFeedbackButton.setOnClickListener(v -> {
            // Get feedback text
            String feedback = feedbackEditText.getText().toString().trim();

            // Check if a rating is selected
            int selectedRatingId = ratingRadioGroup.getCheckedRadioButtonId();
            if (selectedRatingId == -1) {
                Toast.makeText(FeedbackActivity.this, "Please select a rating.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Get selected rating text
            RadioButton selectedRatingButton = findViewById(selectedRatingId);
            String rating = selectedRatingButton.getText().toString();

            // Display feedback and rating in a toast
            Toast.makeText(FeedbackActivity.this,
                    "Feedback: " + feedback + "\nRating: " + rating,
                    Toast.LENGTH_LONG).show();

            // Reset the feedback and rating after submission
            resetFeedbackForm();
            Intent intent = new Intent(FeedbackActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void resetFeedbackForm() {
        feedbackEditText.setText(""); // Clear the feedback input
        ratingRadioGroup.clearCheck(); // Reset the selected rating
    }
}
