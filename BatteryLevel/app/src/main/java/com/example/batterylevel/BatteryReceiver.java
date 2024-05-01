package com.example.batterylevel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BatteryReceiver extends BroadcastReceiver {

    private ProgressBar progressBar;
    private TextView textViewBatteryPercentage;

    public BatteryReceiver(ProgressBar progressBar, TextView textViewBatteryPercentage) {
        this.progressBar = progressBar;
        this.textViewBatteryPercentage = textViewBatteryPercentage;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
        int batteryLevel = (level * 100) / scale;

        progressBar.setProgress(batteryLevel);
        if (textViewBatteryPercentage != null) {
            textViewBatteryPercentage.setText("Battery Level: " + batteryLevel + "%");
        }
    }
}
