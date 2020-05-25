package edu.isel.adeetc.snake.model;

public class SnakePart extends BoardElement {

    /**
     * Initiates the element placing it at the given location.
     *
     * @param position the element's initial position
     */
    protected SnakePart(Location position) {
        super(position);
    }

    public void setPosition(Location position) {
        this.position = position;
    }
}
