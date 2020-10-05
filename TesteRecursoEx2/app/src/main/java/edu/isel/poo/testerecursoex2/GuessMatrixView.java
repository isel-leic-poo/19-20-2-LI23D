package edu.isel.poo.testerecursoex2;

import pt.isel.poo.tile.TilePanel;

public class GuessMatrixView {

    private final GuessMatrix guessMatrix;
    private final TilePanel panel;
    private boolean isRevealed;

    public GuessMatrixView(final TilePanel panel, final GuessMatrix guessMatrix) {
        this.guessMatrix = guessMatrix;
        this.panel = panel;
        this.isRevealed = true;
        updateTiles();
    }

    private void updateTiles() {
        for(int x = 0; x < guessMatrix.side; ++x) {
            for(int y = 0; y < guessMatrix.side; ++y) {
                if(!guessMatrix.getGuessAt(x, y).isElected())
                    panel.setTile(x, y, isRevealed ?
                            new OpenTile(guessMatrix.getGuessAt(x, y)) :
                            new GuessTile(guessMatrix.getGuessAt(x, y))
                    );
            }
        }
    }

    public void revealAll() {
        if (!isRevealed) {
            isRevealed = true;
            updateTiles();
        }
    }

    public void hideAll() {
        if (isRevealed)
            isRevealed = false;
            updateTiles();
    }
}
