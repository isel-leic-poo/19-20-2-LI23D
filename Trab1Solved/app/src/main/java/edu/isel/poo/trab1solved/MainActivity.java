package edu.isel.poo.trab1solved;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import edu.isel.poo.trab1solved.model.DesignModel;
import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Line;
import edu.isel.poo.trab1solved.model.Pixel;
import edu.isel.poo.trab1solved.model.Rectangle;
import edu.isel.poo.trab1solved.view.DesignView;
import edu.isel.poo.trab1solved.view.FigureView;
import edu.isel.poo.trab1solved.view.factories.LineViewFactory;
import edu.isel.poo.trab1solved.view.factories.PixelViewFactory;
import edu.isel.poo.trab1solved.view.factories.RectangleViewFactory;
import edu.isel.poo.trab1solved.view.factories.ViewFactory;

/**
 * Tha application's main activity.
 * It is the Controller in the MVC.
 */
public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private Figure currentFigure;
    private DesignModel model;
    private DesignView view;

    private Map<Integer, ViewFactory> factories;

    private Map<Integer, ViewFactory> initFactories() {
        // We are still violating the OCP principle =P
        Map<Integer, ViewFactory> viewFactories = new HashMap<>();
        viewFactories.put(Line.class.hashCode(), new LineViewFactory());
        viewFactories.put(Rectangle.class.hashCode(), new RectangleViewFactory());
        viewFactories.put(Pixel.class.hashCode(), new PixelViewFactory());
        return viewFactories;
    }

    /**
     * Creates a view instance for the corresponding figure.
     * @param figure - the figure for which the view is to be created.
     * @return The figure view instance that corresponds to the received figure.
     */
    private FigureView createFigureView(Figure figure) {
        ViewFactory factory = factories.get(figure.getClass().hashCode());
        return factory.createView(figure);
    }


    private Figure createFigure(MotionEvent event) {
        RadioGroup group = findViewById(R.id.drawingType);
        // TODO: Can we do differently?
        // We are breaking the OCP (Open-Closed Principle)
        switch (group.getCheckedRadioButtonId()) {
            case R.id.line:
                return new Line((int) event.getX(), (int) event.getY());
            case R.id.pixel:
                return new Pixel((int) event.getX(), (int) event.getY());
            case R.id.rect:
                return new Rectangle((int) event.getX(), (int) event.getY());
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.designView);
        model = new DesignModel();
        view.setModel(model);
        view.setOnTouchListener(this);
        factories = initFactories();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentFigure = createFigure(event);
                model.add(currentFigure);
                view.addFigureView(createFigureView(currentFigure));
                view.invalidate();
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
