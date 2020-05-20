package edu.isel.poo.trab1solved.model;

import java.io.PrintStream;
import java.util.Scanner;

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

    @Override
    protected void saveSpecificData(PrintStream out) {
        out.printf("%d %d %d %d", startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    /**
     * Loads a rectangle from the given input. This method is called through reflexion.
     * @param in - The data source.
     * @return The newly created rectangle.
     */
    protected static final Rectangle loadFrom(Scanner in) {
        Rectangle loadedRectangle = new Rectangle(new Point(in.nextInt(), in.nextInt()));
        loadedRectangle.endPoint = new Point(in.nextInt(), in.nextInt());
        return loadedRectangle;
    }
}
