package edu.isel.adeetc.snake.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

/**
 * Tile used to display an apple.
 */
class AppleTile implements Tile {

    private final Paint brush;

    public AppleTile() {
        brush = new Paint();
        brush.setStyle(Paint.Style.FILL_AND_STROKE);
        brush.setColor(Color.RED);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        canvas.drawCircle(side / 2f, side / 2f, (side / 2f) -4, brush);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
