package edu.isel.adeetc.draw;

import android.graphics.Point;

import androidx.annotation.NonNull;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Represents free-style lines contained in the drawing.
 *
 * Each free-style line is composed of a set of line segments and each line segment is defined
 * by two points: the start point and the ending point. Ultimately, a free-style line is composed
 * of the set of points that define its line segments.
 */
public class FreeStyleLine implements Iterable<Point> {

    /** The set of points that comprise the free-style line */
    private final ArrayList<Point> points = new ArrayList<>();

    /**
     * Creates a free style line with the data extracted from the given input
     * @param input The data source
     * @return      The new instance, or null no data was available
     */
    public static FreeStyleLine createFrom(Scanner input) {

        if (!input.hasNextInt())
            return null;

        FreeStyleLine newLine = new FreeStyleLine();
        int numberOfPoints = input.nextInt();
        while (numberOfPoints-- != 0) {
            Point point = new Point(input.nextInt(), input.nextInt());
            newLine.addPoint(point);
        }

        return newLine;
    }

    /**
     * Adds the given point to the current line.
     * @param p  the point to be added.
     */
    public void addPoint(Point p) {
        points.add(p);
    }

    /**
     * Gets the number of points in the current line.
     * @return  The number of points in the line.
     */
    public int getPointsCount() {
        return points.size();
    }

    @NonNull
    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }

    /**
     * Saves the current line to the given output.
     * @param output    The stream to where the data is to be sent.
     */
    public void save(PrintStream output) {
        //count x0 y0 x1 y1 ... xn yn
        output.print(getPointsCount());
        for (Point p : points) {
            output.printf(" %d %d", p.x, p.y);
        }
        output.println();
    }
}
