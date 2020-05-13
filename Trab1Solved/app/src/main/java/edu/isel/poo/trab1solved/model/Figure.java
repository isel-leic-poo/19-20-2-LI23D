package edu.isel.poo.trab1solved.model;

public abstract class Figure {

    protected Point startPoint;

    protected Figure(Point point) {
        startPoint = point;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public abstract void setEndPoint(Point point);

    public void setEndPoint(int x, int y) {
        setEndPoint(new Point(x, y));
    }

    public abstract Point getEndPoint();
}
