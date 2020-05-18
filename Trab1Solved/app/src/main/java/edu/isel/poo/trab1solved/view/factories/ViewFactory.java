package edu.isel.poo.trab1solved.view.factories;

import edu.isel.poo.trab1solved.model.Figure;
import edu.isel.poo.trab1solved.view.FigureView;

/**
 * Contract to be supported by all view factories
 */
public interface ViewFactory {
    FigureView createView(Figure figure);
}
