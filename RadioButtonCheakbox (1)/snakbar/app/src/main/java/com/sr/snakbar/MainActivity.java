package com.sr.snakbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        final CheckBox checkBoxReading = findViewById(R.id.checkBoxReading);
        final CheckBox checkBoxGaming = findViewById(R.id.checkBoxGaming);
        final CheckBox checkBoxTraveling = findViewById(R.id.checkBoxTraveling);
        final TextView textViewResult = findViewById(R.id.textViewResult);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected gender from the radio group
                int selectedRadioButtonId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String selectedGender = selectedRadioButton.getText().toString();

                // Create a string to store selected hobbies
                StringBuilder selectedHobbies = new StringBuilder();

                // Check if each checkbox is checked and append the text to selectedHobbies
                if (checkBoxReading.isChecked()) {
                    selectedHobbies.append("Reading, ");
                }
                if (checkBoxGaming.isChecked()) {
                    selectedHobbies.append("Gaming, ");
                }
                if (checkBoxTraveling.isChecked()) {
                    selectedHobbies.append("Traveling");
                }

                // Show the result in the TextView
                String result = "Gender: " + selectedGender + "\nHobbies: " + selectedHobbies.toString();
                textViewResult.setText(result);
            }
        });
    }
}
