package edu.isel.poo.trab1solved.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Line;

/**
 * Represents the view used to display a line: The View in the MVC.
 */
public class LineView extends FigureView {

    /**
     * Initiates an instance with the given model.
     * @param model - the view's model.
     */
    public LineView(Line model) {
        super(model);
    }

    @Override
    public void draw(Canvas canvas, Paint brush) {
        // Remember: Down casts are usually 'code smells'
        canvas.drawLine(
                model.getStartPoint().x,
                model.getStartPoint().y,
                model.getEndPoint().x,
                model.getEndPoint().y,
                brush);
    }
}
