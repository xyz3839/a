package com.sr.quecountdoowntimer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTime;
    private TextView textCountdown;
    private Button buttonStart, buttonPause, buttonReset;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis =  60000; // Default time: 1 minute
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTime = findViewById(R.id.editTextTime);
        textCountdown = findViewById(R.id.textCountdown);
        buttonStart = findViewById(R.id.buttonStart);
        buttonPause = findViewById(R.id.buttonPause);
        buttonReset = findViewById(R.id.buttonReset);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountdownText();
    }

    private void startTimer() {
        String input = editTextTime.getText().toString();
        if (input.isEmpty()) {
            return;
        }

        long timeInMinutes = Long.parseLong(input);
        timeLeftInMillis = timeInMinutes * 60000; // Convert minutes to milliseconds

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                buttonStart.setEnabled(true);
                buttonPause.setEnabled(false);
                buttonReset.setEnabled(true);
            }
        }.start();

        timerRunning = true;
        buttonStart.setEnabled(false);
        buttonPause.setEnabled(true);
        buttonReset.setEnabled(false);
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        buttonStart.setEnabled(true);
        buttonPause.setEnabled(false);
        buttonReset.setEnabled(true);
    }

    private void resetTimer() {
        timeLeftInMillis = 0;
        updateCountdownText();
        buttonStart.setEnabled(true);
        buttonPause.setEnabled(false);
        buttonReset.setEnabled(false);
    }

    private void updateCountdownText() {
        int hours = (int) (timeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((timeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        textCountdown.setText(timeLeftFormatted);
    }
}

