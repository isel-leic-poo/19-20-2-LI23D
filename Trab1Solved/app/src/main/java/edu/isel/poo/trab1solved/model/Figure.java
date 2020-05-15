package edu.isel.poo.trab1solved.model;

/**
 * Base class that captures the similarities between figures.
 *
 * All figures have a starting point, that is, the point that corresponds to the screen location
 * that the user initially selected, and an end point, that corresponds to the location where the
 * user specified that the figure should end.
 */
public abstract class Figure {

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

}
