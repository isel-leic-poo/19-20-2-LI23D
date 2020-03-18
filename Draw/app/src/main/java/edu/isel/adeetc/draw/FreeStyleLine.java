package edu.isel.adeetc.draw;

import android.graphics.Point;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;


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
}
