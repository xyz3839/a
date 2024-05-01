package com.example.batterylevel;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar batteryProgressBar;
    private BatteryReceiver batteryReceiver;
    private TextView textViewBatteryPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryProgressBar = findViewById(R.id.batteryProgressBar);
        textViewBatteryPercentage = findViewById(R.id.textViewBatteryPercentage);
        batteryReceiver = new BatteryReceiver(batteryProgressBar, textViewBatteryPercentage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(batteryReceiver);
    }
}
