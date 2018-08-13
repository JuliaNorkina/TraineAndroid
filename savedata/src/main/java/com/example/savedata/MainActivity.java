package com.example.savedata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER = "counter";
    private static final String TAG = "myLogs";
    private TextView tvCounter;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        findViewById(R.id.bCounter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCounter.setText(String.valueOf(++count));
                Log.d(TAG, "onClick counter = " + count);
            }
        });
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(COUNTER);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER, count);
    }
}

