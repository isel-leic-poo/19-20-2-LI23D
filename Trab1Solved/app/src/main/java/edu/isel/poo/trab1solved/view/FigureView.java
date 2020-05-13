package edu.isel.poo.trab1solved.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.poo.trab1solved.model.Figure;

public abstract class FigureView {

    protected final Figure model;

    protected FigureView(Figure model) {
        this.model = model;
    }

    public abstract void draw(Canvas canvas, Paint brush);
}
