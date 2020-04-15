package edu.isel.adeetc.snake.model;

/**
 * Represents the possible movement directions.
 */
public enum Direction {

    NORTH(0, -1),
    SOUTH(0, 1),
    EAST(1, 0),
    WEST(-1, 0);

    final int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
