package edu.isel.adeetc.snake.model;

import java.util.ArrayList;
import java.util.List;

import static edu.isel.adeetc.snake.utils.CollectionUtils.listOf;

/**
 * Represents the snake in the game with the same name.
 */
public class Snake extends SnakePart {

    /**
     * Contract to be supported by snake movement listeners.
     */
    interface MovementListener {
        void snakeHasMoved(List<SnakePart> affectedParts, List<Location> vacated);
    }

    private int arenaWidth, arenaHeight;
    private Direction currentDirection;
    private boolean isDead;

    private ArrayList<MovementListener> listeners;
    private SnakePart tail;

    /**
     * Checks whether the snake can move in the given direction.
     * @param direction The direction to where the movement is to take place.
     * @return true if the move can be made, false otherwise.
     */
    private boolean canMove(Direction direction) {
        final Location newLocation = position.add(direction);
        return newLocation.x >= 0 && newLocation.x < arenaWidth &&
                newLocation.y >= 0 && newLocation.y < arenaHeight;
    }

    public Snake(Location position, Direction initialDirection, int arenaWidth, int arenaHeight, Board board) {
        super(position);
        this.arenaWidth = arenaWidth;
        this.arenaHeight = arenaHeight;
        this.currentDirection = initialDirection;
        this.isDead = false;
        this.listeners = new ArrayList<>();
    }

    /**
     * Moves the snake in the direction it is currently moving.
     */
    public void move() {
        if (isDead)
            throw new IllegalStateException();

        if (canMove(currentDirection)) {
            final List<Location> vacatedPositions = listOf();
            if (tail == null) {
                tail = new SnakePart(position);
            }
            else {
                vacatedPositions.add(tail.getPosition());
                tail.setPosition(position);
            }

            position = position.add(currentDirection);
            final List<SnakePart> movedParts = listOf(this, tail);
            for (MovementListener listener : listeners) {
                listener.snakeHasMoved(movedParts, vacatedPositions);
            }
        }
        else isDead = true;
    }

    public Location getHeadLocation() {
        return getPosition();
    }

    /**
     * Changes the snake movement direction.
     * @param newDirection  the new movement direction.
     */
    public void changeDirection(Direction newDirection) {
        currentDirection = newDirection;
    }

    /**
     * Gets a boolean value indicating whether the snake is dead or not.
     * @return true if the snake is dead, false otherwise.
     */
    public boolean isDead() {
        return isDead;
    }

    /**
     * Registers the given listener to receive snake movement events
     * @param listener  the listener to be registered
     */
    public void addMovementListener(MovementListener listener) {
        listeners.add(listener);
    }

    /**
     * Unregisters the given listener from receiving snake movement events
     * @param listener  the listener to be unregistered
     */
    public void removeMovementListener(MovementListener listener) {
        listeners.remove(listener);
    }

}
