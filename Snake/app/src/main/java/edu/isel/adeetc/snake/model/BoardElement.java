package edu.isel.adeetc.snake.model;

/**
 * Base class for all board game elements.
 */
public abstract class BoardElement {

    protected Location position;

    protected BoardElement(Location position) {
        this.position = position;
    }

    public Location getPosition() {
        return position;
    }
}
