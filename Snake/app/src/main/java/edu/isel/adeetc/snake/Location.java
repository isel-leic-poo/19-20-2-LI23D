package edu.isel.adeetc.snake;

/**
 * Represents a position in the board game.
 * Instances are immutable.
 */
public class Location {

    public final int x, y;

    /**
     * Initiates the instance with the given coordinates
     * @param x the horizontal coordinate
     * @param y the vertical coordinate
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the location that results from computing the displacement of the current location
     * from the given direction.
     * @param direction the displacement
     * @return the new location
     */
    public Location add(Direction direction) {
        // TODO: Prevent the creation of new instances each time add is called (use memoization)
        return new Location(x + direction.dx, y + direction.dy);
    }
}
