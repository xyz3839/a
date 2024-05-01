package com.example.second;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private Spinner conversionSpinner;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.inputNumber);
        conversionSpinner = findViewById(R.id.conversionSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversion_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conversionSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertNumber();
            }
        });
    }

    private void convertNumber() {
        String numberStr = inputNumber.getText().toString();
        if (!numberStr.isEmpty()) {
            int number = Integer.parseInt(numberStr);
            String conversionType = conversionSpinner.getSelectedItem().toString();
            String result;
            if (conversionType.equals("Binary")) {
                result = Integer.toBinaryString(number);
            } else {
                result = Integer.toHexString(number);
            }
            resultText.setText(result);
        }
    }
}