package edu.isel.adeetc.snake.view;

import edu.isel.adeetc.snake.model.Apple;
import edu.isel.adeetc.snake.model.Board;
import edu.isel.adeetc.snake.model.BoardElement;
import edu.isel.adeetc.snake.model.Snake;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

/**
 * The control that displays the game arena.
 */
public class BoardView {

    private final TilePanel panel;
    private final Board board;

    public BoardView(TilePanel panel, Board board) {
        this.panel = panel;
        this.board = board;
        update();
    }

    public void update() {
        // TODO: only change what actually has changed
        for(int x = 0; x < board.arenaWidth; ++x) {
            for(int y = 0; y < board.arenaHeight; ++y) {
                final BoardElement element = board.getElementAt(x, y);
                Tile tile = null;
                if (element instanceof Snake)
                    tile = new SnakeHeadTile();
                else if (element instanceof Apple)
                    tile = new AppleTile();

                panel.setTile(x, y, tile);
            }
        }
    }
}
