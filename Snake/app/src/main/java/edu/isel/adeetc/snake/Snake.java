package edu.isel.adeetc.snake;

/**
 * Represents the snake in the game with the same name.
 *
 * TODO: (3) The snake should remember where it's going
 * TODO: (4) The snake should die when it collides with the arena's boundaries
 */
public class Snake {

    private Location headPosition;
    private int arenaWidth, arenaHeight;

    public Snake(Location position, int arenaWidth, int arenaHeight) {
        headPosition = position;
        this.arenaWidth = arenaWidth;
        this.arenaHeight = arenaHeight;
    }

    public void move(Direction direction) {
        headPosition = headPosition.add(direction);
    }

    public Location getHeadLocation() {
        return headPosition;
    }

    public boolean canMove(Direction direction) {
        final Location newLocation = headPosition.add(direction);
        return newLocation.x >= 0 && newLocation.x < arenaWidth &&
                newLocation.y >= 0 && newLocation.y < arenaHeight;
    }
}
