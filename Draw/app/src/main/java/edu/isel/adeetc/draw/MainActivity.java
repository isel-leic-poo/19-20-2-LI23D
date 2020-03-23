package edu.isel.adeetc.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

class MainActivityMinionRedo implements View.OnClickListener {

    private final MainActivity master;

    MainActivityMinionRedo(MainActivity master) {
        this.master = master;
    }

    @Override
    public void onClick(View v) {
        Log.v("DrawingApp", "Redo button clicked");
    }
}

class MainActivityMinionUndo implements View.OnClickListener {

    private final MainActivity master;

    MainActivityMinionUndo(MainActivity master) {
        this.master = master;
    }

    @Override
    public void onClick(View v) {
        Log.v("DrawingApp", "Undo button clicked");
    }
}

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Drawing model;
    private DrawingView view;
    private FreeStyleLine currentLine;
    private Button undoButton, redoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new Drawing();
        view = findViewById(R.id.drawingView);
        view.setModel(model);
        view.setOnTouchListener(this);

        undoButton = findViewById(R.id.undoButton);
        redoButton = findViewById(R.id.redoButton);

        undoButton.setOnClickListener(new MainActivityMinionUndo(this));
        redoButton.setOnClickListener(new MainActivityMinionRedo(this));
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
