package com.example.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements OnSomeEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
    }

    @Override
    public void someEvent(View view) {
        switch (view.getId()) {
            case R.id.bSend1:
                Fragment fragment2 = getFragmentManager().findFragmentById(R.id.frg2);
                String s = ((EditText) getFragmentManager().findFragmentById(R.id.frg1).getView().findViewById(R.id.etFirst)).getText().toString();
                ((TextView) fragment2.getView().findViewById(R.id.tvSecond)).setText(s);
                break;
            case R.id.bSend2:
                Intent intent = new Intent(this,SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
