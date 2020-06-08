package edu.isel.adeetc.snake.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

/**
 * Tile used to display the snake's head.
 */
class SnakePartTile implements Tile {

    private final Paint brush;

    public SnakePartTile() {
        brush = new Paint();
        brush.setStyle(Paint.Style.FILL_AND_STROKE);
        brush.setColor(Color.GREEN);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        canvas.drawCircle(side /  2, side /  2, side/2 - 4, brush);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
