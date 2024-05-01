package com.sr.que2layout;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textDate;
    private TextView textTime;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDate = findViewById(R.id.textDate);
        textTime = findViewById(R.id.textTime);

        // Update the TextViews with current date and time periodically
        handler.post(updateDateTimeRunnable);
    }

    private Runnable updateDateTimeRunnable = new Runnable() {
        @Override
        public void run() {
            // Get the current date and time
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
            String currentDate = dateFormat.format(new Date());
            String currentTime = timeFormat.format(new Date());

            // Update the TextViews
            textDate.setText(currentDate);
            textTime.setText(currentTime);

            // Schedule the next update after 1 second
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
       handler.removeCallbacks(updateDateTimeRunnable);
    }
}
