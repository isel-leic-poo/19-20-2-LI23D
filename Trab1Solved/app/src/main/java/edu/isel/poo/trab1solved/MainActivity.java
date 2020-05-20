package edu.isel.poo.trab1solved;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.isel.poo.trab1solved.model.DesignModel;
import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Point;
import edu.isel.poo.trab1solved.model.factories.CircleFactory;
import edu.isel.poo.trab1solved.model.factories.FigureFactory;
import edu.isel.poo.trab1solved.model.factories.LineFactory;
import edu.isel.poo.trab1solved.model.factories.PixelFactory;
import edu.isel.poo.trab1solved.model.factories.RectangleFactory;
import edu.isel.poo.trab1solved.view.DesignView;
import edu.isel.poo.trab1solved.view.FigureView;

/**
 * Tha application's main activity.
 * It is the Controller in the MVC.
 */
public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private static final String SAVE_STATE = "SAVE_STATE.txt";
    private Figure currentFigure;
    private DesignModel model;
    private DesignView view;

    private Map<Integer, FigureFactory> figureFactories;

    private Map<Integer, FigureFactory> initFigureFactories() {
        Map<Integer, FigureFactory> figureFactories = new HashMap<>();
        figureFactories.put(R.id.line, new LineFactory());
        figureFactories.put(R.id.pixel, new PixelFactory());
        figureFactories.put(R.id.rect, new RectangleFactory());
        figureFactories.put(R.id.circle, new CircleFactory());
        return figureFactories;
    }

    /**
     * Creates a view instance for the corresponding figure.
     * @param figure - the figure for which the view is to be created.
     * @return The figure view instance that corresponds to the received figure.
     */
    private FigureView createFigureViewWithSteroids(Figure figure) {
        try {
            String viewTypeName = "edu.isel.poo.trab1solved.view." +
                    figure.getClass().getSimpleName() + "View";
            Class viewType = Class.forName(viewTypeName);
            Constructor constructor = viewType.getConstructor(figure.getClass());
            return (FigureView) constructor.newInstance(figure);
        } catch (Exception bug) {
            Log.e("BUG", bug.toString());
            throw new RuntimeException("There is a bug here. Fix me!");
        }
    }

    private Figure createFigure(MotionEvent event) {
        RadioGroup group = findViewById(R.id.drawingType);
        // We are STILL breaking the OCP (Open-Closed Principle)
        FigureFactory factory = figureFactories.get(group.getCheckedRadioButtonId());
        return factory.createFigure(new Point((int) event.getX(), (int) event.getY()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.designView);
        model = new DesignModel();
        view.setOnTouchListener(this);
        figureFactories = initFigureFactories();
        findViewById(R.id.resetButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model = new DesignModel();
                view.clear();
            }
        });

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try (PrintStream out = new PrintStream(openFileOutput(SAVE_STATE, MODE_PRIVATE))) {
                    model.save(out);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.loadButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try (Scanner in = new Scanner(openFileInput(SAVE_STATE))) {
                    model = DesignModel.load(in);
                    view.clear();
                    for (Figure figure : model)
                        view.addFigureView(createFigureViewWithSteroids(figure));
                } catch (FileNotFoundException noFile) {
                    Toast.makeText(MainActivity.this, R.string.file_not_found, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentFigure = createFigure(event);
                model.add(currentFigure);
                view.addFigureView(createFigureViewWithSteroids(currentFigure));
                return true;

            case MotionEvent.ACTION_MOVE:
                currentFigure.setEndPoint((int) event.getX(), (int) event.getY());
                view.invalidate();
                return true;

            case MotionEvent.ACTION_UP:
                currentFigure.setEndPoint((int) event.getX(), (int) event.getY());
                currentFigure = null;
                view.invalidate();
                return true;
        }
        return false;
    }
}
