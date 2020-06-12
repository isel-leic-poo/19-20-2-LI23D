package edu.isel.adeetc.snake.view;

import java.util.List;

import edu.isel.adeetc.snake.model.Apple;
import edu.isel.adeetc.snake.model.Board;
import edu.isel.adeetc.snake.model.BoardElement;
import edu.isel.adeetc.snake.model.Location;
import edu.isel.adeetc.snake.model.Snake;
import edu.isel.adeetc.snake.model.SnakePart;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;

/**
 * The control that displays the game arena.
 */
public class BoardView {

    private final TilePanel panel;
    private final Board board;

    /**
     * Creates the tile used to display the given board element.
     * @param boardElement  - the board element to be displayed
     * @return the newly created tile or null if it's an unknown board element
     */
    private Tile createTile(BoardElement boardElement) {
        if (boardElement instanceof Snake)
            return new SnakeHeadTile(panel.getContext(), (Snake) boardElement);
        else if (boardElement instanceof SnakePart)
            return new SnakePartTile();
        else if (boardElement instanceof Apple)
            return new AppleTile(panel.getContext());
        return null;
    }

    private void updatePosition(Location position) {
        final Tile tile = createTile(board.getElementAt(position.x, position.y));
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
