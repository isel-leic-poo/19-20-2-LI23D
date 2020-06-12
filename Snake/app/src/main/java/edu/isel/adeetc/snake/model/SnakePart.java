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

    @Override
    public CollisionResult collide() {
        return CollisionResult.DIE;
    }

    public void setPosition(Location position) {
        this.position = position;
    }
}
