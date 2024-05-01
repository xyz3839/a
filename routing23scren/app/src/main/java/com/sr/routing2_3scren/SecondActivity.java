package com.sr.routing2_3scren;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// SecondActivity.java

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button buttonGoToThird = findViewById(R.id.buttonGoToThird);

        buttonGoToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
