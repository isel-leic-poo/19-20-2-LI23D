package edu.isel.adeetc.snake.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static edu.isel.adeetc.snake.utils.CollectionUtils.listOf;

/**
 * Represents the snake in the game with the same name.
 */
public class Snake extends SnakePart {

    private static final int INITIAL_SNAKE_SIZE = 4;

    /**
     * Contract to be supported by snake movement listeners.
     */
    interface MovementListener {
        void snakeHasMoved(List<SnakePart> affectedParts, List<Location> vacated);
    }

    private int arenaWidth, arenaHeight;
    private Direction currentDirection;
    private boolean isDead;

    private List<MovementListener> listeners;

    // The list of snake parts
    private LinkedList<SnakePart> body;
    // The snake actual size. If the value is different from the current number of snake parts
    // (+1, the head) then the snake is growing
    private int targetSize;

    public Snake(Location position, Direction initialDirection, int arenaWidth, int arenaHeight, Board board) {
        super(position);
        this.arenaWidth = arenaWidth;
        this.arenaHeight = arenaHeight;
        this.currentDirection = initialDirection;
        this.isDead = false;
        this.targetSize = INITIAL_SNAKE_SIZE;
        this.listeners = new ArrayList<>();
        this.body = new LinkedList<>();
    }

    public Direction getDirection() {
        return currentDirection;
    }

    /**
     * Moves the snake in the direction it is currently moving.
     */
    public void move() {
        if (isDead())
            throw new IllegalStateException();

        if (canMove(currentDirection)) {

            final List<Location> vacatedPositions = listOf();
            final List<SnakePart> movedParts = listOf();

            SnakePart movedPart;
            if (shouldGrow()) {
                movedPart = new SnakePart(position);
            } else {
                movedPart = body.removeLast();
                vacatedPositions.add(movedPart.getPosition());
                movedPart.setPosition(position);
            }

            body.addFirst(movedPart);
            movedParts.add(movedPart);
            position = position.add(currentDirection);
            movedParts.add(this);
            for (MovementListener listener : listeners) {
                listener.snakeHasMoved(movedParts, vacatedPositions);
            }
        }
        else isDead = true;
    }

    /**
     * Gets a boolean value indicating whether the snake is dead or not.
     * @return true if the snake is dead, false otherwise.
     */
    public boolean isDead() {
        return isDead;
    }

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

    /**
     * Checks whether the snake should grow or not.
     * @return  A boolean value indicating if the snake should grow.
     */
    private boolean shouldGrow() {
        return targetSize != body.size() + 1;
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
