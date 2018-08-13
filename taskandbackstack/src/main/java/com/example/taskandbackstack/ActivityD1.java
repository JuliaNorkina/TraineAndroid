package com.example.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityD1 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

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
                Intent intentB = new Intent(this, ActivityB1.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentB.putExtra(Singleton.getSTACK(), " B -> A");
                startActivity(intentB);
                break;
            case R.id.bNext:
                Toast.makeText(this, "No more Activity",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}