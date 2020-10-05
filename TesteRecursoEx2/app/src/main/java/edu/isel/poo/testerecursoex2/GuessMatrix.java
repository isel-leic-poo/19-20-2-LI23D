package edu.isel.poo.testerecursoex2;

import java.util.LinkedList;
import java.util.Random;

public class GuessMatrix {

    private static Guess[][] generateRandomMatrix(int side, int guessCount) {
        final Guess[][] matrix = new Guess[side][side];
        /*
        // Implementation for testing purposes only. DO NOT MODIFY IT!
        for(int i=0; i < side * side; ++i) {
            matrix[i%side][i/side] = new Guess(i < guessCount);
        }
        */
        class Pair {
            public final int x, y;
            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        final LinkedList<Pair> possibleGuesses = new LinkedList<>();
        for(int x = 0; x < side; x++)
            for(int y = 0; y < side; ++y)
                possibleGuesses.add(new Pair(x, y));

        final Random generator = new Random(System.currentTimeMillis());
        while (guessCount-- != 0) {
            final int index = generator.nextInt(possibleGuesses.size());
            Pair toGuess = possibleGuesses.remove(index);
            matrix[toGuess.x][toGuess.y] = new Guess(true);
        }

        for (Pair pair : possibleGuesses) {
            matrix[pair.x][pair.y] = new Guess(false);
        }
        return matrix;
    }

    public interface OnGuessListener {
        void onGuessMade(Guess guess, int x, int y);
    }

    private final Guess[][] content;
    private OnGuessListener listener;
    private int currentGuessCount;

    public final int side;
    public final int totalGuessCount;

    private void fireEvent(Guess guess, int x, int y) {
        if (listener != null)
            listener.onGuessMade(guess, x, y);
    }

    public GuessMatrix(int side, int totalGuessCount) {
        this.side = side;
        this.totalGuessCount = totalGuessCount;
        this.currentGuessCount = 0;
        this.listener = null;
        this.content = generateRandomMatrix(side, totalGuessCount);
    }

    public void makeGuessAt(int x, int y) {
        if (currentGuessCount == totalGuessCount || content[x][y].isElected())
            return;

        content[x][y].setElected();
        currentGuessCount += 1;
        fireEvent(content[x][y], x, y);
    }

    public Guess getGuessAt(int x, int y) {
        return content[x][y];
    }

    public int getCurrentGuessCount() {
        return currentGuessCount;
    }

    public void setOnGuessListener(OnGuessListener listener) {
        this.listener = listener;
    }
}
