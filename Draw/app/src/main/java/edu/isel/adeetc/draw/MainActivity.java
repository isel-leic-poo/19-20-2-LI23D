package edu.isel.adeetc.draw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Drawing model;
    private DrawingView view;
    private FreeStyleLine currentLine;
    private ImageButton undoButton, redoButton;

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
        updateUI();

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.undo();
                updateUI();
            }
        });

        redoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.redo();
                updateUI();
            }
        });
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
                updateUI();
                return true;
            case MotionEvent.ACTION_MOVE:
                currentLine.addPoint(new Point((int) event.getX(), (int) event.getY()));
                view.invalidate();
                return true;
        }
        return false;
    }

    void updateUI() {
        view.invalidate();
        redoButton.setEnabled(model.hasHistory());
        undoButton.setEnabled(model.getLinesCount() != 0);
    }
}
