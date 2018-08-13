package com.example.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityB1 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        TextView tvStack = findViewById(R.id.tvStack);
        Button bBefore = findViewById(R.id.bBefore);
        Button bNext = findViewById(R.id.bNext);

        bBefore.setOnClickListener(this);
        bNext.setOnClickListener(this);

        Intent intent = getIntent();
        tvStack.setText(intent.getStringExtra(Singleton.getSTACK()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bBefore:
                Intent intentA = new Intent(this, ActivityA1.class);
                startActivity(intentA);
                break;
            case R.id.bNext:
                Intent intentC = new Intent(this, ActivityC1.class);
                intentC.putExtra(Singleton.getSTACK(), "A -> B -> C");
                startActivity(intentC);
                break;
        }
    }
}