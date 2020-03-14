package edu.isel.adeetc.draw;

import java.util.ArrayList;


/**
 * Represents drawings composed of several free-style lines.
 */
public class Drawing {

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
     * Gets the lines contained in this drawing.
     * @return  the array with the drawing's lines.
     */
    public FreeStyleLine[] getLines() {
        final FreeStyleLine[] array = new FreeStyleLine[lines.size()];
        lines.toArray(array);
        return array;
    }
}
