package edu.isel.adeetc.snake;

import android.util.Log;

/**
 * Represents the snake in the game with the same name.
 *
 * TODO: document
 */
public class Snake {

    private Location headPosition;

    // TODO: This should be the arena itself
    private int arenaWidth, arenaHeight;


    public Snake(Location position, int arenaWidth, int arenaHeight) {
        headPosition = position;
        this.arenaWidth = arenaWidth;
        this.arenaHeight = arenaHeight;
    }

    public void move(Direction direction) {
        // TODO: Report error if the movement cannot be done
        headPosition = headPosition.add(direction);
    }

    public Location getHeadLocation() {
        return headPosition;
    }

    public boolean canMove(Direction direction) {
        Location newLocation = headPosition.add(direction);
        return newLocation.x >= 0 && newLocation.x < arenaWidth &&
                newLocation.y >= 0 && newLocation.y < arenaHeight;
    }
}
