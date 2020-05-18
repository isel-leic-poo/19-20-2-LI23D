package edu.isel.poo.trab1solved.view.factories;

import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Line;
import edu.isel.poo.trab1solved.view.FigureView;
import edu.isel.poo.trab1solved.view.LineView;

public class LineViewFactory implements ViewFactory {
    @Override
    public FigureView createView(Figure figure) {
        return new LineView((Line) figure);
    }
}
