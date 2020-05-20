package edu.isel.poo.trab1solved.model;

import androidx.annotation.NonNull;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

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

    /**
     * Saves the current drawing to the given stream.
     * @param out - The stream to where the drawing is to be saved.
     */
    public void save(PrintStream out) {
        out.println(figures.size());
        for (Figure figure : figures) {
            figure.save(out);
        }
    }

    /**
     * Loads a drawing from the given input, if possible.
     * @param in - The data source.
     * @return  The newly loaded drawing.
     */
    public static DesignModel load(Scanner in) {
        final DesignModel loadedModel = new DesignModel();
        if (in.hasNextInt()) {
            int count = in.nextInt();
            in.nextLine();
            while (count-- != 0) {
                loadedModel.add(Figure.load(in));
            }
        }
        return loadedModel;
    }
}
