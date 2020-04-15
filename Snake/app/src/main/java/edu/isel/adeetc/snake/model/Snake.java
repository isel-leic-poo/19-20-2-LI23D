package edu.isel.adeetc.snake.model;

/**
 * Represents the snake in the game with the same name.
 */
public class Snake extends BoardElement {

    private int arenaWidth, arenaHeight;
    private Direction currentDirection;
    private boolean isDead;

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

    public void move() {
        if (isDead)
            throw new IllegalStateException();

        if (canMove(currentDirection)) {
            position = position.add(currentDirection);
        }
        else {
            isDead = true;
        }
    }

    public Location getHeadLocation() {
        return getPosition();
    }

    public void changeDirection(Direction newDirection) {
        currentDirection = newDirection;
    }

    public boolean isDead() {
        return isDead;
    }
}
