package edu.isel.adeetc.snake;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import edu.isel.adeetc.snake.model.Board;
import edu.isel.adeetc.snake.model.Direction;
import edu.isel.adeetc.snake.model.Snake;
import edu.isel.adeetc.snake.view.BoardView;
import pt.isel.poo.tile.TilePanel;

/**
 * The game controller.
 */
public class MainActivity extends AppCompatActivity {

    private final Map<Integer, Direction> directions = new HashMap<>();

    {
        directions.put(R.id.upButton, Direction.NORTH);
        directions.put(R.id.downButton, Direction.SOUTH);
        directions.put(R.id.leftButton, Direction.WEST);
        directions.put(R.id.rightButton, Direction.EAST);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TilePanel panel = findViewById(R.id.boardView);
        final Board board = new Board(panel.getWidthInTiles(), panel.getHeightInTiles());
        final Snake snake = board.getSnake();
        // A strange looking line of code... The imperative ways :-/
        new BoardView(panel, board);

        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                snake.changeDirection(directions.get(source.getId()));
            }
        };

        findViewById(R.id.upButton).setOnClickListener(listener);
        findViewById(R.id.downButton).setOnClickListener(listener);
        findViewById(R.id.leftButton).setOnClickListener(listener);
        findViewById(R.id.rightButton).setOnClickListener(listener);

        final TimeAnimator animator = new TimeAnimator();
        animator.setTimeListener(new TimeAnimator.TimeListener() {
            int elapsedTime = 0;
            int interval = 350;
            @Override
            public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
                if (!snake.isDead()) {
                    if (elapsedTime >= interval) {
                        elapsedTime = 0;
                        snake.move();
                    }
                    else {
                        elapsedTime += deltaTime;
                    }
                }
            }
        });
        animator.start();
    }
}
