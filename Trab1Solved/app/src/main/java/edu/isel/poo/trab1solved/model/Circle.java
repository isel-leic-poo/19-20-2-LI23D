package edu.isel.poo.trab1solved.model;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Represents circles in a drawing.
 */
public class Circle extends Figure {

    private int radius;

    /**
     * Initiates the instance with the given start coordinates.
     *
     * @param point - The start point.
     */
    public Circle(Point point) {
        super(point);
        radius = 0;
    }

    @Override
    public Point getEndPoint() {
        return new Point(startPoint.x + radius, startPoint.y);
    }

    @Override
    public void setEndPoint(Point endPoint) {
        Point distance = new Point(startPoint.x - endPoint.x, startPoint.y - endPoint.y);
        radius = (int) Math.sqrt(distance.x * distance.x + distance.y * distance.y);
    }

    /**
     * Gets the circle's radius.
     * @return  The radius.
     */
    public int getRadius() {
        return radius;
    }

    @Override
    protected void saveSpecificData(PrintStream out) {
        out.printf("%d %d %d", startPoint.x, startPoint.y, radius);
    }

    /**
     * Loads a circle from the given input. This method is called through reflexion.
     * @param in - The data source.
     * @return The newly created circle.
     */
    protected static final Circle loadFrom(Scanner in) {
        Circle loadedCircle = new Circle(new Point(in.nextInt(), in.nextInt()));
        loadedCircle.radius = in.nextInt();
        return loadedCircle;
    }
}
