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

/**
 * Represents the view used to display the drawing: The View in the MVC.
 */
public final class DesignView extends View {

    /**
     * The brush used to paint
     */
    private final Paint brush;

    /**
     * The drawing data: the Model in MVC
     */
    private DesignModel model;

    /**
     * Creates a view instance for the corresponding figure.
     * @param figure - the figure for which the view is to be created.
     * @return The figure view instance that corresponds to the received figure.
     */
    private FigureView createFigureView(Figure figure) {
        // TODO: Can we do differently?
        // We are violating the OCP principle
        if (figure instanceof Line)
            return new LineView((Line) figure);
        if (figure instanceof Pixel)
            return new PixelView((Pixel) figure);
        if (figure instanceof Rectangle)
            return new RectangleView((Rectangle) figure);

        return null;
    }

    /**
     * Constructor to support the contract for using the view in a XML UI description file
     * @param context   The view's host
     * @param attrs     The set of attributes specified in the XML file
     */
    public DesignView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeWidth(3);
    }

    /**
     * Associates the given model to this view.
     * I would prefer to pass it as a constructor argument, but the constructor arguments
     * are constrained by Android's platform contract.
     * @param model The object bearing the drawing data, a.k.a., the view's Model.
     */
    public void setModel(DesignModel model) {
        this.model = model;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO: avoid re-creating views
        for(Figure figure : model) {
            FigureView view = createFigureView(figure);
            view.draw(canvas, brush);
        }
    }
}
