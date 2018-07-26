package com.example.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityC extends AppCompatActivity implements View.OnClickListener{

    private static final String STACK = "Stack";

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
        tvStack.setText(intent.getStringExtra(STACK));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bBefore:
                Intent intentB = new Intent(this, ActivityB.class);
                intentB.putExtra(STACK, "B -> A ");
                startActivity(intentB);
                break;
            case R.id.bNext:
                Intent intentD = new Intent(this, ActivityD.class);
                intentD.putExtra(STACK, "A -> B -> C -> D");
                startActivity(intentD);
                break;
        }
    }
}