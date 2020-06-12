package edu.isel.adeetc.snake.model;

/**
 * Base class for all board game elements.
 */
public abstract class BoardElement {

    /**
     * The element's location on the game board.
     */
    protected Location position;

    /**
     * Initiates the element placing it at the given location.
     * @param position  the element's initial position
     */
    protected BoardElement(Location position) {
        this.position = position;
    }

    /**
     * Gets the element's current position.
     * @return  the current position.
     */
    public Location getPosition() {
        return position;
    }

    /**
     * Gets the result of a collision with this element.
     * @return  the collision result.
     */
    public abstract CollisionResult collide();

    /**
     * Used to represent the result of collisions.
     */
    enum CollisionResult { OK, GROW, DIE }
}
