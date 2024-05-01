package com.example.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView profilePicImageView;
    private TextView usernameTextView, emailTextView, phoneTextView, jobProfileTextView;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        profilePicImageView = findViewById(R.id.profilePicImageView);
        usernameTextView = findViewById(R.id.usernameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        jobProfileTextView = findViewById(R.id.jobProfileTextView);
        logoutButton = findViewById(R.id.logoutButton);

        // Set click listener for logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout action
                // For now, just show a toast message
                Toast.makeText(MainActivity.this, "Logging Out", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
