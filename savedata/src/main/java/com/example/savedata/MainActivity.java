package com.example.savedata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String COUNTER = "counter";
    private static final String TAG = "myLogs";
    private TextView tvCounter;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        Button bCounter = findViewById(R.id.bCounter);

        bCounter.setOnClickListener(this);

        if (savedInstanceState!=null){
            count = savedInstanceState.getInt(COUNTER);
        }
    }

    @Override
    public void onClick(View v) {
        tvCounter.setText(String.valueOf(++count));
        Log.d(TAG, "onClick counter = " + count);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER, count);
    }

}

