package edu.isel.adeetc.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.temporal.TemporalUnit;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView totalTimeView = findViewById(R.id.totalTime);
        final TextView partialTimeView = findViewById(R.id.partialTime);

        final TimeAnimator animator = new TimeAnimator();
        animator.setTimeListener(new TimeAnimator.TimeListener() {
            int elapsedTime = 0;
            @Override
            public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
                elapsedTime += deltaTime;
                partialTimeView.setText(Long.toString(deltaTime));
                
                if (elapsedTime >= 250) {
                    totalTimeView.setText(Long.toString(totalTime));
                    elapsedTime = 0;

                }
            }
        });

        findViewById(R.id.startButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });

        final Button pauseButton = findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animator.isPaused()) {
                    pauseButton.setText("Paused");
                    animator.resume();
                }
                else {
                    pauseButton.setText("Resume");
                    animator.pause();
                }
            }
        });
    }
}
