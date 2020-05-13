package edu.isel.poo.trab1solved.model;

public class Pixel extends Figure {


    public Pixel(int x, int y) {
        this(new Point(x, y));
    }

    public Pixel(Point point) {
        super(point);
    }

    @Override
    public void setEndPoint(Point point) {
        startPoint = point;
    }

    @Override
    public Point getEndPoint() {
        return startPoint;
    }
}
