package edu.isel.poo.trab1solved.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.poo.trab1solved.model.Figure;

/**
 * Base class that captures the similarities between figure views.
 *
 * All views have an associated figure (its model) and can be drawn in a canvas.
 */
public abstract class FigureView {

    /**
     * The associated model instance.
     */
    protected final Figure model;

    /**
     * Initiates an instance and associates it with the received model instance.
     * @param model - the figure's model.
     */
    protected FigureView(Figure model) {
        this.model = model;
    }

    /**
     * Draws the figure view in the given canvas with the given brush.
     * @param canvas - The canvas to be drawn on.
     * @param brush - The brush to be used.
     */
    public abstract void draw(Canvas canvas, Paint brush);
}
