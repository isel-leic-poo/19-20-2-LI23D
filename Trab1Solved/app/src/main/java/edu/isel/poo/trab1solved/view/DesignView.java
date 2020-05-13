package edu.isel.poo.trab1solved.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import edu.isel.poo.trab1solved.model.DesignModel;
import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Line;
import edu.isel.poo.trab1solved.model.Pixel;
import edu.isel.poo.trab1solved.model.Rectangle;

public final class DesignView extends View {

    private final Paint brush;
    private DesignModel model;

    public DesignView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(Figure figure : model) {
            FigureView view = createFigureView(figure);
            view.draw(canvas, brush);
        }
    }

    private FigureView createFigureView(Figure figure) {
        // TODO: Can we do differently?
        if (figure instanceof Line)
            return new LineView((Line) figure);
        if (figure instanceof Pixel)
            return new PixelView((Pixel) figure);
        if (figure instanceof Rectangle)
            return new RectangleView((Rectangle) figure);

        return null;
    }

    public void setModel(DesignModel model) {
        this.model = model;
    }
}
