package edu.isel.adeetc.snake.view;

import java.util.List;

import edu.isel.adeetc.snake.model.Apple;
import edu.isel.adeetc.snake.model.Board;
import edu.isel.adeetc.snake.model.BoardElement;
import edu.isel.adeetc.snake.model.Location;
import edu.isel.adeetc.snake.model.Snake;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

/**
 * The control that displays the game arena.
 */
public class BoardView {

    private final TilePanel panel;
    private final Board board;

    private void updatePosition(Location position) {
        final BoardElement element = board.getElementAt(position.x, position.y);
        Tile tile = null;
        if (element instanceof Snake)
            tile = new SnakeHeadTile();
        else if (element instanceof Apple)
            tile = new AppleTile();

        panel.setTile(position.x, position.y, tile);
    }

    public BoardView(TilePanel panel, Board board) {
        this.panel = panel;
        this.board = board;
        initialize();
        board.addChangeListener(new Board.ChangeListener() {
            @Override
            public void onChanged(List<Location> changedLocations) {
                for (Location location : changedLocations) {
                    updatePosition(location);
                }
            }
        });
    }

    private void initialize() {
        for(int x = 0; x < board.arenaWidth; ++x) {
            for(int y = 0; y < board.arenaHeight; ++y) {
                // TODO: Prevent the instantiation of all these objects
                updatePosition(new Location(x, y));
            }
        }
    }
}
