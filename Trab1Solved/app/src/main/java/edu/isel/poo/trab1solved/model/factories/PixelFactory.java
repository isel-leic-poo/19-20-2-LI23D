package edu.isel.poo.trab1solved.model.factories;

import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Pixel;
import edu.isel.poo.trab1solved.model.Point;

public class PixelFactory implements FigureFactory {
    @Override
    public Figure createFigure(Point start) {
        return new Pixel(start);
    }
}
