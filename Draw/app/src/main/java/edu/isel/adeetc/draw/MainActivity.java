package edu.isel.adeetc.draw;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    public static final String FILE = "Data.txt";
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

        findViewById(R.id.clearButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setModel(model = new Drawing());
                updateUI();
            }
        });

        findViewById(R.id.loadButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Create model instances from the external representation
                try (Scanner input = new Scanner(openFileInput(FILE))) {
                    model = Drawing.createFrom(input);
                    view.setModel(model);
                    updateUI();
                } catch (FileNotFoundException e) {
                    // TODO: Error handling for real
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try (PrintStream output = new PrintStream(openFileOutput(FILE, MODE_PRIVATE))) {
                    model.save(output);
                    // For reference:
                    // model.save(System.out);
                } catch (FileNotFoundException e) {
                    // TODO: Error handling for real
                    e.printStackTrace();
                }
            }
        });

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.undo();
            }
        });

        redoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.redo();
            }
        });

        model.setListener(new Drawing.OnChangeListener() {
            @Override
            public void onChange(Drawing source) {
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
