package edu.isel.poo.trab1solved.model.factories;

import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Line;
import edu.isel.poo.trab1solved.model.Point;

public class LineFactory implements FigureFactory {
    @Override
    public Figure createFigure(Point start) {
        return new Line(start);
    }
}
