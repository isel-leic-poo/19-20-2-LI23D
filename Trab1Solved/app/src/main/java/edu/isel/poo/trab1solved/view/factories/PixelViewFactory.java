package edu.isel.poo.trab1solved.view.factories;

import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.model.Pixel;
import edu.isel.poo.trab1solved.view.FigureView;
import edu.isel.poo.trab1solved.view.PixelView;

public class PixelViewFactory implements ViewFactory {
    @Override
    public FigureView createView(Figure figure) {
        return new PixelView((Pixel) figure);
    }
}
