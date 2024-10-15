package com.example.sportszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {
    private EditText edtFeedback;
    private CheckBox checkboxTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback); // Make sure this matches your layout file name

        edtFeedback = findViewById(R.id.edtFeedback);
        checkboxTerms = findViewById(R.id.checkboxTerms);

        Button btnSubmitFeedback = findViewById(R.id.btnSubmitFeedback);
        btnSubmitFeedback.setOnClickListener(v -> submitFeedback());
    }

    private void submitFeedback() {
        String feedback = edtFeedback.getText().toString();

        // Check if terms are accepted
        if (checkboxTerms.isChecked()) {
            Toast.makeText(this, "Feedback submitted: " + feedback, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FeedbackActivity.this, MainActivity.class);
            startActivity(intent);
            // Optionally clear fields
            resetFields();
        } else {
            Toast.makeText(this, "Please accept the terms and conditions", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetFields() {
        edtFeedback.setText("");
        checkboxTerms.setChecked(false);
    }
}
