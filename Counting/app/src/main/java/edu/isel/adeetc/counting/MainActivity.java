package edu.isel.adeetc.counting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView counterView = findViewById(R.id.counterView);
        Log.v("CountingApp",
                "Text on counterView is " + counterView.getText());

        findViewById(R.id.incButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("CountingApp", "Inc button clicked");
            }
        });

        findViewById(R.id.decButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("CountingApp", "Dec button clicked");
            }
        });

        Log.v("CountingApp", "onCreate() ends");
    }
}
