package edu.isel.poo.trab1solved.model.factories;

import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Point;
import edu.isel.poo.trab1solved.model.Rectangle;

public class RectangleFactory implements FigureFactory {
    @Override
    public Figure createFigure(Point start) {
        return new Rectangle(start);
    }
}
