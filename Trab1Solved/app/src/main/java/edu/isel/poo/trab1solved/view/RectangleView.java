package edu.isel.poo.trab1solved.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.poo.trab1solved.model.Rectangle;

public class RectangleView extends FigureView {

    public RectangleView(Rectangle model) {
        super(model);
    }

    public void draw(Canvas canvas, Paint brush) {
        // TODO: Could we do differently?
        final Rectangle rectangle = (Rectangle) model;
        canvas.drawRect(
                rectangle.getStartPoint().x,
                rectangle.getStartPoint().y,
                rectangle.getEndPoint().x,
                rectangle.getEndPoint().y,
                brush);
    }

}
