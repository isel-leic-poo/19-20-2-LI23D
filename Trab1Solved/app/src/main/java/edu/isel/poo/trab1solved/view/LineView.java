package edu.isel.poo.trab1solved.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.poo.trab1solved.model.Line;

public class LineView extends FigureView {

    public LineView(Line model) {
        super(model);
    }

    public void draw(Canvas canvas, Paint brush) {
        // TODO: Could we do differently?
        final Line line = (Line) model;
        canvas.drawLine(
                line.getStartPoint().x,
                line.getStartPoint().y,
                line.getEndPoint().x,
                line.getEndPoint().y,
                brush);
    }
}
