package com.example.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityA2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        TextView tvStack = findViewById(R.id.tvStack);
        Button bBefore = findViewById(R.id.bBefore);
        Button bNext = findViewById(R.id.bNext);

        bBefore.setOnClickListener(this);
        bNext.setOnClickListener(this);

        tvStack.setText("A");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bBefore:
                Toast.makeText(this, R.string.root_activity, Toast.LENGTH_SHORT).show();
                break;
            case R.id.bNext:
                Intent intentA = new Intent(this, ActivityB2.class);
                intentA.putExtra(Singleton.getSTACK(), "A -> B (new task)");
                startActivity(intentA);
                break;
        }
    }
}
