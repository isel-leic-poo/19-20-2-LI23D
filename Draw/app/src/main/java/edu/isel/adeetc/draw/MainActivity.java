package edu.isel.adeetc.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Drawing model;
    private DrawingView view;
    private FreeStyleLine currentLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new Drawing();
        view = new DrawingView(this, model);
        view.setOnTouchListener(this);
        setContentView(view);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.v("DrawingApp", "ACTION_DOWN");
                currentLine = new FreeStyleLine();
                model.add(currentLine);
                return true;

            case MotionEvent.ACTION_UP:
                Log.v("DrawingApp", "ACTION_UP");
                currentLine = null;
                return true;
            case MotionEvent.ACTION_MOVE:
                currentLine.addPoint(new Point((int) event.getX(), (int) event.getY()));
                view.invalidate();
                return true;
        }
        return false;
    }
}
