package edu.isel.poo.trab1solved.model.factories;

import edu.isel.poo.trab1solved.model.Circle;
import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Point;

public class CircleFactory implements FigureFactory {
    @Override
    public Figure createFigure(Point start) {
        return new Circle(start);
    }
}
