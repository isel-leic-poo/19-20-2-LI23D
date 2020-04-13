package edu.isel.adeetc.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TimeAnimator;
import android.os.Bundle;

import pt.isel.poo.tile.TilePanel;

/**
 * The game controller.
 *
 * TODO: (5) Add buttons that make the snake change direction
 * TODO: (6) Stop movement when snake dies
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TilePanel panel = findViewById(R.id.boardView);
        final Snake snake = new Snake(new Location(0, 0),
                panel.getWidthInTiles(), panel.getHeightInTiles());
        final BoardView board = new BoardView(panel, snake);

        final TimeAnimator animator = new TimeAnimator();
        animator.setTimeListener(new TimeAnimator.TimeListener() {
            int elapsedTime = 0;
            @Override
            public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
                if (elapsedTime >= 1000) {
                    elapsedTime = 0;
                    if (snake.canMove(Direction.SOUTH)) {
                        Location prev = snake.getHeadLocation();
                        snake.move(Direction.SOUTH);
                        board.update(prev);
                    }
                }
                elapsedTime += deltaTime;
            }
        });
        animator.start();
    }
}
