package edu.isel.poo.testerecursoex2;

public class Guess {
    public final boolean isInPattern;
    private boolean elected;
    public Guess(boolean isInPattern) { this.isInPattern = isInPattern; this.elected = false; }
    public void setElected() {
        this.elected = true;
    }
    public boolean isCorrect() {
        return this.elected == this.isInPattern;
    }
    public boolean isElected() { return this.elected; }
}
