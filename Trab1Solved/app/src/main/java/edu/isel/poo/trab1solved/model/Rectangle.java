package edu.isel.poo.trab1solved.model;

/**
 * Small deviation from the provided diagram =P
 */
public class Rectangle extends Figure {

    private Point endPoint;

    public Rectangle(Point point) {
        super(point);
        endPoint = point;
    }

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
}
