package com.sr.sound;
// MainActivity.java
// MainActivity.java

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false; // Flag to track if sound is currently playing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize MediaPlayer
        mediaPlayer = new MediaPlayer();
        Button buttonSound1 = findViewById(R.id.buttonSound1);
        buttonSound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if sound is currently playing
                if (isPlaying) {
                    // If sound is playing, stop it
                    stopSound();
                    isPlaying = false; // Update flag
                } else {
                    // If sound is not playing, start it
                    playSound(R.raw.sound1);
                    isPlaying = true; // Update flag
                }
            }
        });
    }
    private void playSound(int soundResource) {
        // Reset MediaPlayer to stop any currently playing sound
        mediaPlayer.reset();
        // Load the specified sound resource
        mediaPlayer = MediaPlayer.create(getApplicationContext(), soundResource);
        // Start playing the loaded sound
        mediaPlayer.start();
    }
    private void stopSound() {
        // Check if MediaPlayer is currently playing
        if (mediaPlayer.isPlaying()) {
            // If yes, stop it
            mediaPlayer.stop();
            // Release resources
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer when the activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
