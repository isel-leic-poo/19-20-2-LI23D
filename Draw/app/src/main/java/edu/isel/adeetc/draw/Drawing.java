package edu.isel.adeetc.draw;

import java.util.ArrayList;


public class Drawing {

    private final ArrayList<FreeStyleLine> lines;

    public Drawing() {
        this.lines = new ArrayList<>();
    }

    public void add(FreeStyleLine line) {
        lines.add(line);
    }

    public FreeStyleLine[] getLines() {
        final FreeStyleLine[] array = new FreeStyleLine[lines.size()];
        lines.toArray(array);
        return array;
    }

}
