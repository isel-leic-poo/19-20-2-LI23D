package edu.isel.adeetc.snake;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.isel.adeetc.snake.model.Board;
import edu.isel.adeetc.snake.model.Direction;
import edu.isel.adeetc.snake.model.Snake;
import edu.isel.adeetc.snake.view.BoardView;
import pt.isel.poo.tile.TilePanel;

/**
 * The game controller.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TilePanel panel = findViewById(R.id.boardView);
        final Board board = new Board(panel.getWidthInTiles(), panel.getHeightInTiles());
        final BoardView boardView = new BoardView(panel, board);
        final Snake snake = board.getSnake();

        // TODO: Use an associative container to get rid of the switch case
        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                switch (source.getId()) {
                    case R.id.upButton: snake.changeDirection(Direction.NORTH); break;
                    case R.id.downButton: snake.changeDirection(Direction.SOUTH); break;
                    case R.id.leftButton: snake.changeDirection(Direction.WEST); break;
                    case R.id.rightButton: snake.changeDirection(Direction.EAST); break;
                }
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
                        boardView.update();
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
