package edu.isel.adeetc.counting;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Counter counter;

    private void initializeView() {
        setContentView(R.layout.activity_main);
        Log.v("CountingApp", "initializeView() ends");
    }

    private void initializeModel() {
        counter = new Counter(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeView();
        initializeModel();

        final TextView counterView = findViewById(R.id.counterView);
        Log.v("CountingApp",
                "Text on counterView is " + counterView.getText());

        findViewById(R.id.incButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("CountingApp", "Inc button clicked");
                counter.increment();
                counterView.setText(counter.toString());
            }
        });

        findViewById(R.id.decButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("CountingApp", "Dec button clicked");
                counter.decrement();
                counterView.setText(counter.toString());
            }
        });

        Log.v("CountingApp", "onCreate() ends");
    }
}
