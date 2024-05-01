package com.sr.autolist;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private Button showInputButton; // Descriptive name

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        showInputButton = findViewById(R.id.showInput); // Assuming ID is defined in layout

        String[] itemArray = getResources().getStringArray(R.array.itemList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemArray);
        autoCompleteTextView.setAdapter(adapter);

        showInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedNumber = autoCompleteTextView.getText().toString();
                if (selectedNumber.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please select a number", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Selected number: " + selectedNumber, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}