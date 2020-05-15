package edu.isel.poo.trab1solved.model;

import androidx.annotation.NonNull;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Represents the drawing data: the Model in the MVC.
 * A drawing is composed of figures.
 */
public class DesignModel implements Iterable<Figure> {

    /**
     * The drawing's figures.
     */
    private final LinkedList<Figure> figures;

    /**
     * Initiates an empty drawing.
     */
    public DesignModel() {
        figures = new LinkedList<>();
    }

    /**
     * Adds the given figure to the current drawing.
     * @param figure - the figure to be added to the drawing.
     */
    public void add(Figure figure) {
        figures.add(figure);
    }

    @NonNull
    @Override
    public Iterator<Figure> iterator() {
        return figures.iterator();
    }
}
