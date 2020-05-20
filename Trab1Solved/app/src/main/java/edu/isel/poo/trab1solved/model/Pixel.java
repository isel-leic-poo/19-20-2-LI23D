package edu.isel.poo.trab1solved.model;

import java.io.PrintStream;
import java.util.Scanner;

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

    @Override
    protected void saveSpecificData(PrintStream out) {
        out.printf("%d %d", startPoint.x, startPoint.y);
    }

    /**
     * Loads a rectangle from the given input. This method is called through reflexion.
     * @param in - The data source.
     * @return The newly created rectangle.
     */
    protected static final Pixel loadFrom(Scanner in) {
        Pixel loadedPixel = new Pixel(new Point(in.nextInt(), in.nextInt()));
        return loadedPixel;
    }
}
