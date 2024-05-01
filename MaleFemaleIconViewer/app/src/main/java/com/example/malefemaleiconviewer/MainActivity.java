package com.example.malefemaleiconviewer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.malefemaleiconviewer.R;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonMale) {
                    imageView.setImageResource(R.drawable.img_1);
                } else if (checkedId == R.id.radioButtonFemale) {
                    imageView.setImageResource(R.drawable.img);
                }
            }
        });
    }
}
