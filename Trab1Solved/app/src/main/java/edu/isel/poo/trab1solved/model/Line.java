package edu.isel.poo.trab1solved.model;


import java.io.PrintStream;
import java.util.Scanner;

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

    @Override
    protected void saveSpecificData(PrintStream out) {
        out.printf("%d %d %d %d", startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    /**
     * Loads a line from the given input. This method is called through reflexion.
     * @param in - The data source.
     * @return The newly created line.
     */
    protected static final Line loadFrom(Scanner in) {
        Line loadedLine = new Line(new Point(in.nextInt(), in.nextInt()));
        loadedLine.endPoint = new Point(in.nextInt(), in.nextInt());
        return loadedLine;
    }
}
