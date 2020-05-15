package edu.isel.poo.trab1solved;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import edu.isel.poo.trab1solved.model.DesignModel;
import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Line;
import edu.isel.poo.trab1solved.model.Pixel;
import edu.isel.poo.trab1solved.model.Rectangle;
import edu.isel.poo.trab1solved.view.DesignView;

/**
 * Tha application's main activity.
 * It is the Controller in the MVC.
 */
public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private Figure currentFigure;
    private DesignModel model;
    private DesignView view;

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
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentFigure = createFigure(event);
                model.add(currentFigure);
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
