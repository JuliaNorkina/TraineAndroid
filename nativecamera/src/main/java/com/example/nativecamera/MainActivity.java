package com.example.nativecamera;

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

        Button bCamera = findViewById(R.id.bCamera);
        Button bOther = findViewById(R.id.bOther);

        bCamera.setOnClickListener(this);
        bOther.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bCamera:
                Intent intent = new Intent(this, CameraActivity.class);
                startActivity(intent);
                break;
            case R.id.bOther:
                Intent intent1 = new Intent(this, OtherActivity.class);
                startActivity(intent1);
                break;
        }

    }
}
