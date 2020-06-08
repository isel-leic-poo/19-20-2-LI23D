package edu.isel.adeetc.snake.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the game board.
 */
public class Board {

    /**
     * Contract to be supported by snake movement listeners.
     */
    public interface ChangeListener {
        void onChanged(List<Location> changedLocations);
    }

    /**
     * Bi-dimensional array used for easily indexing the elements placed in the board.
     */
    private final BoardElement[][] elements;
    private final List<ChangeListener> listeners;

    /**
     * The snake instance.
     */
    private Snake snake;

    /**
     * The board's boundaries.
     */
    public final int arenaWidth, arenaHeight;

    private void initApple() {
        final Location location = new Location(arenaWidth / 2, arenaHeight / 2);
        elements[location.x][location.y] = new Apple(location);
    }

    private void initSnake() {
        snake = new Snake(new Location(0, 0), Direction.SOUTH, arenaWidth, arenaHeight, this);
        elements[0][0] = snake;
    }

    private void fireChangeEvent(List<Location> changedList) {
        for (ChangeListener listener : listeners) {
            listener.onChanged(changedList);
        }
    }

    /**
     * Initializes the game board with the given dimension.
     * @param width     the arena's width
     * @param height    the arena's height
     */
    public Board(int width, int height) {
        arenaWidth = width;
        arenaHeight = height;
        elements = new BoardElement[width][height];
        listeners = new LinkedList<>();
        initSnake();
        initApple();
        snake.addMovementListener(new Snake.MovementListener() {
            @Override
            public void snakeHasMoved(List<SnakePart> affectedParts, List<Location> vacated) {
                final List<Location> changedList = new ArrayList<>();
                for (Location location : vacated) {
                    elements[location.x][location.y] = null;
                    changedList.add(location);
                }
                for (SnakePart snakePart : affectedParts) {
                    elements[snakePart.getPosition().x][snakePart.getPosition().y] = snakePart;
                    changedList.add(snakePart.getPosition());
                }

                fireChangeEvent(changedList);
            }
        });
    }
    /**
     * Gets the board element at the given position
     * @param x the horizontal coordinate
     * @param y the vertical coordinate
     * @return  The board element at the specified position, or null
     */
    public BoardElement getElementAt(int x, int y) {
        return elements[x][y];
    }

    /**
     * Gets the snake instance.
     * @return  the snake instance.
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * Registers the given listener to receive board change events.
     * @param listener the listener to be registered.
     */
    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Unregisters the given listener.
     * @param listener the listener to be unregistered.
     */
    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(listener);
    }
}
