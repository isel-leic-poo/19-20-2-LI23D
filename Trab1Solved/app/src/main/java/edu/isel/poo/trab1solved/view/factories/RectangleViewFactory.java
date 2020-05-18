package edu.isel.poo.trab1solved.view.factories;

import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Rectangle;
import edu.isel.poo.trab1solved.view.FigureView;
import edu.isel.poo.trab1solved.view.RectangleView;

public class RectangleViewFactory implements ViewFactory {
    @Override
    public FigureView createView(Figure figure) {
        return new RectangleView((Rectangle) figure);
    }
}
