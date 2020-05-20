package edu.isel.poo.trab1solved.model;


/**
 * Represents lines in a drawing.
 */
public class Line extends Figure {

    /**
     * The line's end point.
     */
    private Point endPoint;

    /**
     * Initiates an instance with the given starting point coordinates.
     * @param x - The horizontal coordinate.
     * @param y - The vertical coordinate.
     */
    public Line(int x, int y) {
        this(new Point(x, y));
    }

    /**
     * Initiates an instance with the given starting point coordinates.
     * @param start - The point instance representing the starting point coordinates.
     */
    public Line(Point start) {
        super(start);
        endPoint = startPoint;
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
