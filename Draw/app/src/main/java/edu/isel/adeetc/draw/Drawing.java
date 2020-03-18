package edu.isel.adeetc.draw;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents drawings composed of several free-style lines.
 */
public class Drawing implements Iterable<FreeStyleLine> {

    /** The lines in the drawing */
    private final ArrayList<FreeStyleLine> lines = new ArrayList<>();

    /**
     * Adds the given line to the current drawing.
     * @param line  the line to be added.
     */
    public void add(FreeStyleLine line) {
        lines.add(line);
    }

    /**
     * Gets the number of lines in the current drawing.
     * @return  The number of lines in the drawing.
     */
    public int getLinesCount() {
        return lines.size();
    }

    @NonNull
    @Override
    public Iterator<FreeStyleLine> iterator() {
        return lines.iterator();
    }
}
