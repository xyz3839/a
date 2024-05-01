package com.example.scrollablelist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Define the array of programming languages here
    String[] programmingLanguages = {"Java", "C++", "Python", "JavaScript", "Kotlin", "Swift","android studio","VS code","ReactNative","NodeJS","Mearn Stack","Docker","GO Lang","Kubernates","HTML","CSS","C","C#","PHP","Fluter"};

    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, programmingLanguages);
        listView.setAdapter(adapter);

        // Setting ListView to be scrollable
        listView.setScrollContainer(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
