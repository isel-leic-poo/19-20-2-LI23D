package edu.isel.adeetc.snake.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import edu.isel.adeetc.snake.R;
import pt.isel.poo.tile.Img;
import pt.isel.poo.tile.Tile;

/**
 * Tile used to display an apple.
 */
class AppleTile implements Tile {

    private final Paint brush;
    private final Img image;

    public AppleTile(Context context) {
        brush = new Paint();
        brush.setStyle(Paint.Style.FILL_AND_STROKE);
        brush.setColor(Color.RED);
        image = new Img(context, R.mipmap.red_apple);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        image.draw(canvas, side, side, brush);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
