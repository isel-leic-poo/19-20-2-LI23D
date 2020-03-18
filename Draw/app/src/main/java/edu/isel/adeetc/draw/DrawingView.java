package edu.isel.adeetc.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * View that displays the drawing area and its contents.
 */
public class DrawingView extends View {

    /** The brush that will be used to paint. */
    private final Paint brush;

    /** The view's model */
    private final Drawing drawing;

    /**
     * Initializes an instance with the given context (e.g. the hosting Activity)
     * @param context   The context to which the view will be bound.
     */
    public DrawingView(Context context, Drawing model) {
        super(context);
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStrokeWidth(10);
        brush.setStyle(Paint.Style.STROKE);
        this.drawing = model;
    }

    /**
     * Callback method that is called whenever the view is to be drawn.
     * @param canvas The canvas where the drawing is to be done.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(FreeStyleLine line : drawing.getLines())
            drawFreeStyleLine(canvas, line);
    }

    /**
     * Draws the given line in the given canvas
     * @param canvas
     * @param line
     */
    private void drawFreeStyleLine(Canvas canvas, FreeStyleLine line) {

        final Point[] points = line.getPoints();
        if(points.length == 0)
            return;

        Point startPoint = points[0];
        for (int idx = 1; idx < points.length; ++idx) {
            Point endPoint = points[idx];
            canvas.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y, brush);
            startPoint = endPoint;
        }
    }

}
