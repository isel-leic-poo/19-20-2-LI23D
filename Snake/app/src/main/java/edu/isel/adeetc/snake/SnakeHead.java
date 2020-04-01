package edu.isel.adeetc.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

class SnakeHead implements Tile {

    private final Paint brush;

    public SnakeHead() {
        brush = new Paint();
        brush.setStyle(Paint.Style.FILL_AND_STROKE);
        brush.setColor(Color.RED);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        canvas.drawRect(4, 4, side-4, side-4, brush);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
