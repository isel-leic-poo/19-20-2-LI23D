package edu.isel.adeetc.draw;

import androidx.annotation.NonNull;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Represents drawings composed of several free-style lines.
 */
public class Drawing implements Iterable<FreeStyleLine> {

    /** The lines in the drawing */
    private final ArrayList<FreeStyleLine> lines = new ArrayList<>();

    /** The lines that where removed from the drawing */
    private final ArrayList<FreeStyleLine> history = new ArrayList<>();

    public static Drawing createFrom(Scanner input) {
        Drawing newDrawing = new Drawing();
        FreeStyleLine newLine = null;
        while((newLine = FreeStyleLine.createFrom(input)) != null) {
            newDrawing.add(newLine);
        }
        return newDrawing;
    }

    /**
     * Adds the given line to the current drawing.
     * @param line  the line to be added.
     */
    public void add(FreeStyleLine line) {
        lines.add(line);
        history.clear();
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

    /**
     * Removes the last added line from the drawing, if one exists.
     */
    public void undo() {
        moveLine(lines, history);
    }

    /**
     * Adds again to the drawing the last removed line, if one exists.
     */
    public void redo() {
        moveLine(history, lines);
    }

    private void moveLine(ArrayList<FreeStyleLine> from, ArrayList<FreeStyleLine> to) {
        if (from.size() != 0) {
            final FreeStyleLine line = from.remove(from.size() - 1);
            to.add(line);
        }
    }

    public boolean hasHistory() {
        return history.size() != 0;
    }

    public void save(PrintStream output) {
        for (FreeStyleLine line : lines) {
            line.save(output);
        }
    }
}
