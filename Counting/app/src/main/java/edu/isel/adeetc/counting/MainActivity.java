package edu.isel.adeetc.counting;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Counter counter1;
    private Counter counter2;

    private void initializeView() {
        setContentView(R.layout.activity_main);
        updateView();
        Log.v("CountingApp", "initializeView() ends");
    }

    private void initializeModel() {
        counter1 = new Counter(0);
        counter2 = new Counter(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeModel();
        initializeView();

        findViewById(R.id.incButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1.increment();
                updateView();
            }
        });

        findViewById(R.id.decButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1.decrement();
                updateView();
            }
        });

        findViewById(R.id.incButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2.increment();
                updateView();
            }
        });

        findViewById(R.id.decButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2.decrement();
                updateView();
            }
        });

        Log.v("CountingApp", "onCreate() ends");
    }

    private void updateView() {
        final TextView counterView1 = findViewById(R.id.counterView1);
        counterView1.setText(counter1.toString());
        findViewById(R.id.decButton1).setEnabled(counter1.getValue() != 0);

        final TextView counterView2 = findViewById(R.id.counterView2);
        counterView2.setText(counter2.toString());
        findViewById(R.id.decButton2).setEnabled(counter2.getValue() != 0);
    }
}
