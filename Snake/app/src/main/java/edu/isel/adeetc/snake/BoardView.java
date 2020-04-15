package edu.isel.adeetc.snake;

import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

/**
 * The control that displays the game arena.
 *
 * TODO: (7) Create class AppleTile
 * TODO: (8) Create class Apple
 * TODO: (9) Create class Board
 */
public class BoardView {

    private final Snake snake;
    private final TilePanel panel;

    public BoardView(TilePanel panel, Snake snake) {
        this.panel = panel;
        this.snake = snake;
        panel.setTile(snake.getHeadLocation().x, snake.getHeadLocation().y, new SnakeHeadTile());
    }

    public void update(Location prevLocation) {
        final Tile headTile = panel.getTile(prevLocation.x, prevLocation.y);
        panel.setTile(prevLocation.x, prevLocation.y, null);
        panel.setTile(snake.getHeadLocation().x, snake.getHeadLocation().y, headTile);
    }
}
