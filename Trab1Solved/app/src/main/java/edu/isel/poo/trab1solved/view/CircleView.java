package edu.isel.poo.trab1solved.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.poo.trab1solved.model.Circle;

public class CircleView extends FigureView {

    /**
     * Initiates an instance and associates it with the received model instance.
     *
     * @param model - the figure's model.
     */
    public CircleView(Circle model) {
        super(model);
    }

    @Override
    public void draw(Canvas canvas, Paint brush) {
        canvas.drawCircle(
                model.getStartPoint().x,
                model.getStartPoint().y,
                ((Circle) model).getRadius(),
                brush
        );
    }
}
