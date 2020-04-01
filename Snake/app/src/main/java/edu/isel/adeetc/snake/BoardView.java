package edu.isel.adeetc.snake;

import pt.isel.poo.tile.TilePanel;

public class BoardView {

    private final Snake snake;
    private final TilePanel panel;

    private void displayHead(TilePanel panel, Snake snake) {
        final Location headLocation = snake.getHeadLocation();
        panel.setTile(headLocation.x, headLocation.y, new SnakeHead());
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
