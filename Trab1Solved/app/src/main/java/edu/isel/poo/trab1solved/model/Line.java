package edu.isel.poo.trab1solved.model;


public class Line extends Figure {

    private Point endPoint;

    public Line(int x, int y) {
        this(new Point(x, y));
        endPoint = startPoint;
    }

    public Line(Point start) {
        super(start);
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
