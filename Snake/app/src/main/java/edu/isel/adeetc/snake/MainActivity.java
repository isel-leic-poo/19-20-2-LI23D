package edu.isel.adeetc.snake;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TimeAnimator;
import android.os.Bundle;
import android.view.View;

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
        final Snake snake = new Snake(new Location(0, 0), Direction.SOUTH,
                panel.getWidthInTiles(), panel.getHeightInTiles());
        final BoardView board = new BoardView(panel, snake);

        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Handle event according to its source
            }
        };

        findViewById(R.id.upButton).setOnClickListener(listener);
        findViewById(R.id.downButton).setOnClickListener(listener);
        findViewById(R.id.leftButton).setOnClickListener(listener);
        findViewById(R.id.rightButton).setOnClickListener(listener);

        final TimeAnimator animator = new TimeAnimator();
        animator.setTimeListener(new TimeAnimator.TimeListener() {
            int elapsedTime = 0;
            @Override
            public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
                if (!snake.isDead()) {
                    if (elapsedTime >= 1000) {
                        elapsedTime = 0;
                        Location prev = snake.getHeadLocation();
                        snake.move();
                        board.update(prev);
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
