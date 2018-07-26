package com.example.taskandbackstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityD extends AppCompatActivity implements View.OnClickListener{

    private static final String STACK = "Stack";
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
        tvStack.setText(intent.getStringExtra(STACK));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bBefore:
                Intent intentC = new Intent(this, ActivityC.class);
                intentC.putExtra(STACK, "C -> B -> A");
                startActivity(intentC);
                break;
            case R.id.bNext:
                Toast.makeText(this, "No more Activity",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}