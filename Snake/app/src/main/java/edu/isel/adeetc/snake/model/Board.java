package edu.isel.adeetc.snake.model;

public class Board {

    private final BoardElement[][] elements;
    private Snake snake;

    public final int arenaWidth, arenaHeight;

    private void initApple() {
        final Location location = new Location(arenaWidth / 2, arenaHeight / 2);
        elements[location.x][location.y] = new Apple(location);
    }

    private void initSnake() {
        snake = new Snake(new Location(0, 0), Direction.SOUTH, arenaWidth, arenaHeight);
        elements[0][0] = snake;
    }

    public Board(int width, int height) {
        arenaWidth = width;
        arenaHeight = height;
        elements = new BoardElement[width][height];
        initSnake();
        initApple();
    }

    public void changeSnakeDirection(Direction newDirection) {
        snake.changeDirection(newDirection);
    }

    public void doSnakeMove() {
        Location prevPosition = snake.getPosition();
        snake.move();
        elements[prevPosition.x][prevPosition.y] = null;
        elements[snake.getPosition().x][snake.getPosition().y] = snake;
    }

    public BoardElement getElementAt(int x, int y) {
        return elements[x][y];
    }

    public boolean isSnakeDead() {
        return snake.isDead();
    }
}
