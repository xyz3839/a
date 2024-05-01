package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find all buttons by their IDs
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);

        // Set click listeners for all buttons
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showToast("Button 1 clicked");
        } else if (v.getId() == R.id.button2) {
            showToast("Button 2 clicked");
        } else if (v.getId() == R.id.button3) {
            showToast("Button 3 clicked");
        } else if (v.getId() == R.id.button4) {
            showToast("Button 4 clicked");
        } else if (v.getId() == R.id.button5) {
            showToast("Button 5 clicked");
        } else if (v.getId() == R.id.button6) {
            showToast("Button 6 clicked");
        } else if (v.getId() == R.id.button7) {
            showToast("Button 7 clicked");
        }

    }

    // Function to display toast message
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
