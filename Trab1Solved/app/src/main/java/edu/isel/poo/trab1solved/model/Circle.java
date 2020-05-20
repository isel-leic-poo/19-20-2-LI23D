package edu.isel.poo.trab1solved.model;

public class Circle extends Figure {

    private Point endPoint;

    /**
     * Initiates the instance with the given start coordinates.
     *
     * @param point - The start point.
     */
    public Circle(Point point) {
        super(point);
        endPoint = point;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    public void setEndPoint(Point point) {
        endPoint = point;
    }

    public int getRadius() {
        return endPoint.subtract(startPoint).mod();
    }
}
