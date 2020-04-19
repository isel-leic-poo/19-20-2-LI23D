package edu.isel.adeetc.snake.model;

/**
 * Represents the snake in the game with the same name.
 */
public class Snake extends BoardElement {

    private int arenaWidth, arenaHeight;
    private Direction currentDirection;
    private boolean isDead;

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

    public Snake(Location position, Direction initialDirection, int arenaWidth, int arenaHeight) {
        super(position);
        this.arenaWidth = arenaWidth;
        this.arenaHeight = arenaHeight;
        this.currentDirection = initialDirection;
        this.isDead = false;
    }

    /**
     * Moves the snake in the direction it is currently moving.
     */
    public void move() {
        if (isDead)
            throw new IllegalStateException();
        if (canMove(currentDirection)) position = position.add(currentDirection);
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
}
