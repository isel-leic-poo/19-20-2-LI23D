package edu.isel.poo.testerecursoex2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

public class GuessTile implements Tile {

    private static final int MARGIN = 15;
    private static final int ERROR_COLOR = Color.RED;
    private static final int OK_COLOR = Color.parseColor("#558BC2");

    private final Paint brush;
    private final Guess model;

    public GuessTile(Guess value) {
        this.model = value;
        this.brush = new Paint();
        this.brush.setStyle(Paint.Style.FILL_AND_STROKE);
        this.brush.setStrokeWidth(7);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        if (model.isElected()) {
            if (model.isCorrect() && model.isInPattern) {
                brush.setColor(OK_COLOR);
                canvas.drawRect(MARGIN, MARGIN, side - MARGIN, side - MARGIN, brush);
            }
            else {
                brush.setColor(ERROR_COLOR);
                canvas.drawLine(MARGIN, MARGIN, side - MARGIN, side - MARGIN, brush);
                canvas.drawLine(side - MARGIN, MARGIN, MARGIN, side - MARGIN, brush);
            }
        }
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
