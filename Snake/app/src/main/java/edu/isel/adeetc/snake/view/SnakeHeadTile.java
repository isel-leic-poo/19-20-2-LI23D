package edu.isel.adeetc.snake.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import edu.isel.adeetc.snake.R;
import edu.isel.adeetc.snake.model.Direction;
import edu.isel.adeetc.snake.model.Snake;
import pt.isel.poo.tile.Img;
import pt.isel.poo.tile.Tile;

import static edu.isel.adeetc.snake.model.Direction.*;

/**
 * Tile used to display the snake's head.
 */
class SnakeHeadTile implements Tile {

    private final Paint brush;
    private final Img image;
    private final Snake model;

    public SnakeHeadTile(Context ctx, Snake snake) {
        brush = new Paint();
        brush.setStyle(Paint.Style.FILL_AND_STROKE);
        brush.setColor(Color.GREEN);
        image = new Img(ctx, R.mipmap.snake_head);
        model = snake;
    }

    @Override
    public void draw(Canvas canvas, int side) {
        Direction currentDirection = model.getDirection();
        float rotation = 0;
        switch (currentDirection) {
            case SOUTH: rotation = 0; break;
            case WEST: rotation = 90; break;
            case NORTH: rotation = 180; break;
            case EAST: rotation = 270; break;
        }
        image.draw(canvas, side, side, rotation, brush);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
