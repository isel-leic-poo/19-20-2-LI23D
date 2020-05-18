package edu.isel.poo.trab1solved.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.poo.trab1solved.model.Pixel;

/**
 * Represents the view used to display a pixel: The View in the MVC.
 */
public class PixelView extends FigureView {

    /**
     * Initiates an instance with the given model.
     * @param model - the view's model.
     */
    public PixelView(Pixel model) {
        super(model);
    }

    @Override
    public void draw(Canvas canvas, Paint brush) {
        // Remember: Down casts are usually 'code smells'
        final float previousStroke = brush.getStrokeWidth();
        brush.setStrokeWidth(10);
        canvas.drawPoint(
                model.getStartPoint().x,
                model.getStartPoint().y,
                brush);
        brush.setStrokeWidth(previousStroke);
    }
}
