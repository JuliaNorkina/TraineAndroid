package com.example.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityC2 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

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
                Intent intentB = new Intent(this, ActivityB2.class);
                intentB.putExtra(Singleton.getSTACK(), "B -> A ");
                startActivity(intentB);
                break;
            case R.id.bNext:
                Intent intentD = new Intent(this, ActivityD2.class);
                intentD.putExtra(Singleton.getSTACK(), "A -> B (new task) -> C -> D");
                startActivity(intentD);
                break;
        }
    }
}