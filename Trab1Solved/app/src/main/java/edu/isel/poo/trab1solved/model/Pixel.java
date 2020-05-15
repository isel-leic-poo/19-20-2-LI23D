package edu.isel.poo.trab1solved.model;

/**
 * Represents pixels in a drawing.
 * The pixel's start and end points are the same.
 */
public class Pixel extends Figure {

    /**
     * Initiates an instance with the given coordinates.
     * @param x - The horizontal coordinate.
     * @param y - The vertical coordinate.
     */
    public Pixel(int x, int y) {
        this(new Point(x, y));
    }

    /**
     * Initiates an instance with the given coordinates.
     * @param point - The point instance representing the coordinates.
     */
    public Pixel(Point point) {
        super(point);
    }

    @Override
    public void setEndPoint(Point point) {
        startPoint = point;
    }

    @Override
    public Point getEndPoint() {
        return startPoint;
    }
}
