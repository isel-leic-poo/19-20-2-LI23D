package edu.isel.adeetc.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * View that displays the drawing area and its contents.
 */
public class DrawingView extends View {

    /** The brush that will be used to paint. */
    private final Paint brush;

    /**
     * Initializes an instance with the given context (e.g. the hosting Activity)
     * @param context   The context to which the view will be bound.
     */
    public DrawingView(Context context) {
        super(context);
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStrokeWidth(10);
        brush.setStyle(Paint.Style.STROKE);
    }

    /**
     * Callback method that is called whenever the view is to be drawn.
     * @param canvas The canvas where the drawing is to be done.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 0, getWidth(), getHeight(), brush);
    }
}
