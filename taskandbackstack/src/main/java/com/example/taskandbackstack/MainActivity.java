package com.example.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bFirst = findViewById(R.id.bFirst);
        Button bSecond = findViewById(R.id.bSecond);

        bFirst.setOnClickListener(this);
        bSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bFirst:
                Intent intent = new Intent(this, ActivityA1.class);
                startActivity(intent);
                break;
            case R.id.bSecond:
                Intent intent1 = new Intent(this, ActivityA2.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                break;
        }
    }
}
