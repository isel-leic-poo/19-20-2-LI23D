package edu.isel.poo.testerecursoex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import pt.isel.poo.tile.OnTileTouchListener;
import pt.isel.poo.tile.TilePanel;

class OnTileTouchAdapter implements OnTileTouchListener {
    @Override public boolean onClick(int xTile, int yTile) { return false; }
    @Override public boolean onDrag(int xFrom, int yFrom, int xTo, int yTo) { return false; }
    @Override public void onDragEnd(int x, int y) { }
    @Override public void onDragCancel() { }
}

interface IA { }; interface IB extends IA { }; class C1 implements IB { };  class C2 implements IA { };

public class MainActivity extends AppCompatActivity {

    final int SIDE = 6, TO_MEMORIZE = 8;
    private Button startButton;
    private TilePanel panel;

    static void xpto2(List<String> list, String a) {
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            if (it.next().equals(a))
                it.remove();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String> list = new LinkedList<>();
        list.add("SLB");
        list.add("O");
        list.add("MAIOR");
        Log.v("WOT", "" + list.size());

        panel = findViewById(R.id.tilePanel);
        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                xpto2(list, "SLB");
                Log.v("WOT", "" + list.size());
                final GuessMatrix model = new GuessMatrix(SIDE, TO_MEMORIZE);
                final GuessMatrixView view = new GuessMatrixView(panel, model);
                button.setEnabled(false);
                panel.setListener(new OnTileTouchAdapter() {
                    @Override
                    public boolean onClick(int xTile, int yTile) {
                        if (model.getGuessAt(xTile, yTile).isElected()) return false;
                        model.makeGuessAt(xTile, yTile);
                        panel.invalidate(xTile, yTile);
                        return true;
                    }

                });
                startDelayed(5, model, view);
            }
        });
    }

    private void runDelayed(int secondsOfDelay, Runnable codeToRun) {
        // Any view can be used below, so lets use the one we have, the button
        startButton.postDelayed(codeToRun, secondsOfDelay * 1000);
    }
    private void endDelayed(int secondsOfDelay, final GuessMatrixView view) {
        runDelayed(secondsOfDelay, new Runnable() {
            @Override
            public void run() {
                view.revealAll();
                startButton.setEnabled(true);
            }
        });
        this.isChangingConfigurations()
    }

    private void startDelayed(int secondsOfDelay, final GuessMatrix model, final GuessMatrixView view) {
        runDelayed(secondsOfDelay, new Runnable() {
            @Override
            public void run() {
                view.hideAll();
                model.setOnGuessListener(new GuessMatrix.OnGuessListener() {
                    @Override
                    public void onGuessMade(Guess guess, int x, int y) {
                        if (model.getCurrentGuessCount() == model.totalGuessCount) {
                            panel.setListener(null);
                            endDelayed(5, view);
                        }
                    }
                });
            }
        });
    }
}