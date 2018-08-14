package com.example.checkboxwithfragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbRed = findViewById(R.id.cbRed);
        CheckBox cbGreen = findViewById(R.id.cbGreen);
        CheckBox cbBlue = findViewById(R.id.cbBlue);
        cbRed.setOnCheckedChangeListener(this);
        cbGreen.setOnCheckedChangeListener(this);
        cbBlue.setOnCheckedChangeListener(this);
        Log.d("log", "onCreate");

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (buttonView.getId()) {
            case R.id.cbRed:
                if (isChecked) {
                    transaction.add(R.id.flForFragment, MyFragment.newInstance(ContextCompat.getColor(this, R.color.red)), "red");

                } else {
                    transaction.remove(getFragmentManager().findFragmentByTag("red"));
                }
                break;
            case R.id.cbGreen:
                if (isChecked) {
                    transaction.add(R.id.flForFragment, MyFragment.newInstance(ContextCompat.getColor(this, R.color.green)), "green");
                } else {
                    transaction.remove(getFragmentManager().findFragmentByTag("green"));
                }
                break;
            case R.id.cbBlue:
                if (isChecked) {
                    transaction.add(R.id.flForFragment, MyFragment.newInstance(ContextCompat.getColor(this, R.color.blue)), "blue");
                } else {
                    transaction.remove(getFragmentManager().findFragmentByTag("blue"));
                }
                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
