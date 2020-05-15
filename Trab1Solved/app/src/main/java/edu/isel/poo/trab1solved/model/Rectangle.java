package edu.isel.poo.trab1solved.model;

/**
 * Represents rectangles in a drawing.
 *
 * A rectangle is described by the two points that delimit one of its diagonals
 * (for drawing purposes, it doesn't matter which diagonal it is)
 */
public class Rectangle extends Figure {

    /**
     * The end point of the rectangle's diagonal.
     */
    private Point endPoint;

    /**
     * Initiates an instance with the given starting point coordinates.
     * @param start - The point instance representing the starting point coordinates.
     */
    public Rectangle(Point start) {
        super(start);
        endPoint = start;
    }

    /**
     * Initiates an instance with the given starting point coordinates.
     * @param x - The horizontal coordinate.
     * @param y - The vertical coordinate.
     */
    public Rectangle(int x, int y) {
        this(new Point(x, y));
    }

    @Override
    public void setEndPoint(Point point) {
        endPoint = point;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }
}
