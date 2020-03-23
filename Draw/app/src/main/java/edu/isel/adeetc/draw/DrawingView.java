package edu.isel.adeetc.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import java.util.Iterator;

/**
 * View that displays the drawing area and its contents.
 */
public class DrawingView extends View {

    /** The brush that will be used to paint. */
    private final Paint brush;

    /** The view's model */
    private Drawing drawing;

    /**
     * Initializes an instance with the given context (e.g. the hosting Activity)
     * @param context   The context to which the view will be bound.
     */
    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStrokeWidth(10);
        brush.setStyle(Paint.Style.STROKE);
        drawing = null;
    }

    /**
     * Sets the view model.
     * @param model the view's model.
     */
    public void setModel(Drawing model) {
        this.drawing = model;
    }

    /**
     * Callback method that is called whenever the view is to be drawn.
     * @param canvas The canvas where the drawing is to be done.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (drawing == null)
            return;

        for(FreeStyleLine line : drawing)
            drawFreeStyleLine(canvas, line);
    }

    /**
     * Draws the given line in the given canvas
     * @param canvas
     * @param line
     */
    private void drawFreeStyleLine(Canvas canvas, FreeStyleLine line) {

        if (line.getPointsCount() == 0)
            return;

        final Iterator<Point> itr = line.iterator();
        Point startPoint = itr.next();

        while (itr.hasNext()) {
            final Point endPoint = itr.next();
            canvas.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y, brush);
            startPoint = endPoint;
        }
    }

}
