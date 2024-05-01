package com.sr.snackbarproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonShowSnackbar = findViewById(R.id.buttonShowSnackbar);

        buttonShowSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "This is a Snackbar", Snackbar.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "Iam snakbar", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
