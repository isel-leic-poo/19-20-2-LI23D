package edu.isel.poo.trab1solved.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.poo.trab1solved.model.Rectangle;

/**
 * Represents the view used to display a rectangle: The View in the MVC.
 */
public class RectangleView extends FigureView {

    /**
     * Initiates an instance with the given model.
     * @param model - the view's model.
     */
    public RectangleView(Rectangle model) {
        super(model);
    }

    @Override
    public void draw(Canvas canvas, Paint brush) {
        // Remember: Down casts are usually 'code smells'
        canvas.drawRect(
                model.getStartPoint().x,
                model.getStartPoint().y,
                model.getEndPoint().x,
                model.getEndPoint().y,
                brush);
    }

}
