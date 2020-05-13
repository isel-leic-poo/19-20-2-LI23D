package edu.isel.poo.trab1solved.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.poo.trab1solved.model.Pixel;

public class PixelView extends FigureView {

    public PixelView(Pixel model) {
        super(model);
    }

    public void draw(Canvas canvas, Paint brush) {
        // TODO: Could we do differently?
        final Pixel pixel = (Pixel) model;
        canvas.drawPoint(
                pixel.getStartPoint().x,
                pixel.getStartPoint().y,
                brush);
    }

}
