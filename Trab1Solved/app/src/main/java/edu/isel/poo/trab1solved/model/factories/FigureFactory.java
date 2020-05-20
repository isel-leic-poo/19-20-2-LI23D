package edu.isel.poo.trab1solved.model.factories;

import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Point;

public interface FigureFactory {
    Figure createFigure(Point start);
}
