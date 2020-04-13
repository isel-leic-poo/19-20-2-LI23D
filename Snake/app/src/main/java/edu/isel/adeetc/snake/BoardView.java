package edu.isel.adeetc.snake;

import pt.isel.poo.tile.TilePanel;

/**
 * The control that displays the game arena.
 *
 * TODO: (2) Change implementation to reduce the number of temporary objects that are created
 * TODO: (7) Create class AppleTile
 * TODO: (8) Create class Apple
 * TODO: (9) Create class Board
 */
public class BoardView {

    private final Snake snake;
    private final TilePanel panel;

    private void displayHead(TilePanel panel, Snake snake) {
        final Location headLocation = snake.getHeadLocation();
        panel.setTile(headLocation.x, headLocation.y, new SnakeHeadTile());
    }

    public BoardView(TilePanel panel, Snake snake) {
        this.panel = panel;
        this.snake = snake;
        displayHead(panel, snake);
    }


    public void update(Location prevLocation) {
        panel.setTile(prevLocation.x, prevLocation.y, null);
        displayHead(panel, snake);
    }
}
