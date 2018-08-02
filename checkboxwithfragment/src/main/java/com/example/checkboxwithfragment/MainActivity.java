package com.example.checkboxwithfragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private MyFragment myFragment;
    private FragmentTransaction transaction;

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
        myFragment = new MyFragment();
        transaction = getFragmentManager().beginTransaction();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cbRed:
                if (isChecked) {
                    myFragment.setFragmentBackground(R.color.red);
                    transaction.add(R.id.flForFragment, myFragment);
                    transaction.commit();
                }
                break;
            case R.id.cbGreen:
                if (isChecked) {
                    myFragment.setFragmentBackground(R.color.green);
                    transaction.add(R.id.flForFragment, myFragment);
                    transaction.commit();
                }
                break;
            case R.id.cbBlue:
                if (isChecked) {
                    myFragment.setFragmentBackground(R.color.blue);
                    transaction.add(R.id.flForFragment, myFragment);
                    transaction.commit();
                }
                break;
        }
    }
}
