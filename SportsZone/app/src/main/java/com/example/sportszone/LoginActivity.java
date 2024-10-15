package com.example.sportszone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin, btnRegister;
    private TextInputLayout passwordLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.edtSignInUsername);
        etPassword = findViewById(R.id.edtSignInPassword);
        btnLogin = findViewById(R.id.btnSignIn);
        passwordLayout = findViewById(R.id.passwordLayout);

        setupPasswordVisibilityToggle();
        setupLoginButton();
    }

    private void setupPasswordVisibilityToggle() {
        passwordLayout.setEndIconMode(TextInputLayout.END_ICON_PASSWORD_TOGGLE);
    }

    private void setupLoginButton() {
        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Input Validation
            boolean isValid = true;

            if (username.isEmpty()) {
                etUsername.setError("Username is required");
                isValid = false;
            } else {
                etUsername.setError(null);
            }

            if (password.isEmpty()) {
                passwordLayout.setError("Password is required");
                isValid = false;
            } else {
                passwordLayout.setError(null);
            }

            if (isValid) {
                performLogin(username, password);
            }
        });
    }

    private void performLogin(String username, String password) {
        // Simulate login success (for now, no real authentication)
        if (username.equals("user") && password.equals("pass")) {
            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            // Go to the main screen
            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
        }
    }
}