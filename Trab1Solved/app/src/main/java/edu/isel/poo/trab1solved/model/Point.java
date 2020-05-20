package edu.isel.poo.trab1solved.model;

/**
 * Represents cartesian coordinates.
 * Instances are immutable.x
 */
public class Point {

    /**
     * The point's horizontal coordinate.
     */
    public final int x;

    /**
     * The point's vertical coordinate.
     */
    public final int y;

    /**
     * Initiates an instance with the given coordinates.
     * @param x - The point's horizontal coordinate.
     * @param y - The point's vertical coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
