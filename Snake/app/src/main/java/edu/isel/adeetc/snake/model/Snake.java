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
    private static final int SNAKE_GROWTH_RATE = 4;

    /**
     * Used to represent the result of a snake movement.
     */
    private enum MovementResult { OK, GROW, DIE }

    /**
     * Contract to be supported by snake movement listeners.
     */
    interface MovementListener {
        void snakeHasMoved(List<SnakePart> affectedParts, List<Location> vacated);
    }

    private int arenaWidth, arenaHeight;
    private Direction currentDirection;
    private boolean isDead;
    private Board board;

    private List<MovementListener> listeners;

    // The list of snake parts
    private LinkedList<SnakePart> body;
    // The snake actual size. If the value is different from the current number of snake parts
    // (+1, the head) then the snake is growing
    private int targetSize;

    /**
     * Initiates a Snake instance.
     * @param position          - the initial snake coordinates.
     * @param initialDirection  - the initial movement direction.
     * @param board             - the board where the snake is.
     */
    public Snake(Location position, Direction initialDirection, Board board) {
        super(position);
        this.arenaWidth = board.arenaWidth;
        this.arenaHeight = board.arenaHeight;
        this.currentDirection = initialDirection;
        this.isDead = false;
        this.targetSize = INITIAL_SNAKE_SIZE;
        this.listeners = new ArrayList<>();
        this.body = new LinkedList<>();
        this.board = board;
    }

    /**
     * Gets the direction in which the snake is moving
     * @return  the snake's movement direction
     */
    public Direction getDirection() {
        return currentDirection;
    }

    /**
     * Moves the snake in the direction it is currently moving.
     */
    public void move() {
        if (isDead())
            throw new IllegalStateException();

        final MovementResult result = tryMove(currentDirection);
        if (result == MovementResult.DIE) {
            isDead = true;
            return;
        }

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

        if (result == MovementResult.GROW)
            growBy(SNAKE_GROWTH_RATE);
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
    private MovementResult tryMove(Direction direction) {
        final Location newLocation = position.add(direction);
        return (newLocation.x >= 0 && newLocation.x < arenaWidth &&
                newLocation.y >= 0 && newLocation.y < arenaHeight) ?
            detectCollisionAt(newLocation) : MovementResult.DIE;
    }

    /**
     * Method that checks if a collision will occur at the specified location, returning the
     * collision consequence.
     * @param location  - the location where a collision is to be verified.
     * @return  The collision consequence.
     */
    private MovementResult detectCollisionAt(Location location) {
        final BoardElement elementAtDestination = board.getElementAt(location.x, location.y);

        // TODO: use polymorphism to address this
        if (elementAtDestination instanceof Apple)
            return MovementResult.GROW;

        if (elementAtDestination instanceof SnakePart)
            return MovementResult.DIE;

        return MovementResult.OK;
    }

    /**
     * Checks whether the snake should grow or not.
     * @return  A boolean value indicating if the snake should grow.
     */
    private boolean shouldGrow() {
        return targetSize != body.size() + 1;
    }

    /**
     * Makes the snake grow by the given ammount.
     */
    private void growBy(int addedSize) {
        targetSize += addedSize;
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
