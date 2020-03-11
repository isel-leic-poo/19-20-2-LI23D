package edu.isel.adeetc.draw;

import android.graphics.Point;
import java.util.ArrayList;

public class FreeStyleLine {

    private final ArrayList<Point> points;

    public FreeStyleLine() {
        points = new ArrayList<>();
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public Point[] getPoints() {
        final Point[] array = new Point[points.size()];
        points.toArray(array);
        return array;
    }
}
