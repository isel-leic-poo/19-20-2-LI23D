package edu.isel.poo.trab1solved.model;

import androidx.annotation.NonNull;

import java.util.Iterator;
import java.util.LinkedList;

public class DesignModel implements Iterable<Figure> {

    private final LinkedList<Figure> figures;

    public DesignModel() {
        figures = new LinkedList<>();
    }

    public void add(Figure figure) {
        figures.add(figure);
    }

    @NonNull
    @Override
    public Iterator<Figure> iterator() {
        return figures.iterator();
    }
}
