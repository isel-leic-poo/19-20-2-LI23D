package edu.isel.poo.testerecursoex2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

public class OpenTile implements Tile {

    private static final int MARGIN = 15;
    private static final int COLOR = Color.parseColor("#AA8BC2");

    private final Paint brush;
    private final Guess model;

    public OpenTile(Guess value) {
        this.model = value;
        this.brush = new Paint();
        this.brush.setColor(COLOR);
        this.brush.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        if (model.isInPattern)
            canvas.drawRect(MARGIN, MARGIN, side - MARGIN, side - MARGIN, brush);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
