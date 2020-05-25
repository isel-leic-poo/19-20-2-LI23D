package edu.isel.poo.trab1solved.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents the view used to display the drawing: The View in the MVC.
 */
public final class DesignView extends View {

    private final List<FigureView> views;

    /**
     * The brush used to paint
     */
    private final Paint brush;

    /**
     * Constructor to support the contract for using the view in a XML UI description file
     * @param context   The view's host
     * @param attrs     The set of attributes specified in the XML file
     */
    public DesignView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        views = new LinkedList<>();
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(FigureView view : views) {
            view.draw(canvas, brush);
        }
    }

    /**
     * Adds the given figure view to the drawing.
     * @param view - the view to be added.
     */
    public void addFigureView(FigureView view) {
        views.add(view);
        invalidate();
    }

    /**
     * Clears the drawing.
     */
    public void clear() {
        views.clear();
        invalidate();
    }
}
