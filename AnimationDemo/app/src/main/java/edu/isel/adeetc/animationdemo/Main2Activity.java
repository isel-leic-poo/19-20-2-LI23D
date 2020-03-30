package edu.isel.adeetc.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Ball ball = new Ball(new Vector(0, 0), 50);
        final AnimationView view = new AnimationView(this, ball);
        setContentView(view);

        ball.setVelocity(new Vector(70, 100));

        final TimeAnimator animator = new TimeAnimator();
        animator.setTimeListener(new TimeAnimator.TimeListener() {
            int elapsedTime = 0;
            @Override
            public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
                elapsedTime += deltaTime;
                if (elapsedTime >= 50) {
                    elapsedTime = 0;
                    ball.move();
                    view.invalidate();
                }
            }
        });

        animator.start();
    }
}
