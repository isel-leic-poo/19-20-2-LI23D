package edu.isel.poo.trab1solved.model;

import android.util.Log;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Base class that captures the similarities between figures.
 *
 * All figures have a starting point, that is, the point that corresponds to the screen location
 * that the user initially selected, and an end point, that corresponds to the location where the
 * user specified that the figure should end.
 */
public abstract class Figure {

    public static Figure load(Scanner in) {
        try {
            String className = in.next();
            Class figureType = Class.forName("edu.isel.poo.trab1solved.model." + className);
            Method loadMethod = figureType.getDeclaredMethod("loadFrom", Scanner.class);
            Figure loadedFigure = (Figure) loadMethod.invoke(null, in);
            in.nextLine();
            return loadedFigure;
        } catch (Exception bug) {
            Log.e("BUG", bug.toString());
            throw new RuntimeException("There is a bug here. Fix me!");
        }
    }

    /**
     * All figures have an initial point.
     */
    protected Point startPoint;

    /**
     * Initiates the instance with the given start coordinates.
     * @param point - The start point.
     */
    protected Figure(Point point) {
        startPoint = point;
    }

    /**
     * Gets the figure's start point. The actual meaning of "start point" depends of each concrete
     * figure.
     * @return  the start point.
     */
    public Point getStartPoint() {
        return startPoint;
    }

    /**
     * Gets the figure's end point. The actual meaning of "end point" depends of each concrete
     * figure.
     * @return  the end point.
     */
    public abstract Point getEndPoint();

    /**
     * Sets the figure's end point. The actual meaning of "end point" depends of each concrete
     * figure.
     * @param x - the point's horizontal coordinate.
     * @param y - the point's vertical coordinate.
     */
    public void setEndPoint(int x, int y) {
        setEndPoint(new Point(x, y));
    }

    /**
     * Sets the figure's end point. The actual meaning of "end point" depends of each concrete
     * figure.
     * @param point - the point.
     */
    public abstract void setEndPoint(Point point);

    /**
     * Saves the figure data to the given stream.
     * The figure data ocupies exactly one line of text, starting with the class name.
     * @param out - The stream where the data is to be saved to.
     */
    public final void save(PrintStream out) {
        out.print(getClass().getSimpleName() + " ");
        saveSpecificData(out);
        out.println();
    }

    /**
     * Saves the figure's specific data.
     * @param out - The stream where the data is to be saved to.
     */
    protected abstract void saveSpecificData(PrintStream out);
}
