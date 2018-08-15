package com.example.checkboxwithfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox cbRed;
    CheckBox cbGreen;
    CheckBox cbBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbRed = findViewById(R.id.cbRed);
        cbGreen = findViewById(R.id.cbGreen);
        cbBlue = findViewById(R.id.cbBlue);

        cbRed.setOnCheckedChangeListener(this);
        cbGreen.setOnCheckedChangeListener(this);
        cbBlue.setOnCheckedChangeListener(this);
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentById = getSupportFragmentManager().getFragments();
        if (!fragmentById.isEmpty()) {
            switch (fragmentById.get(0).getTag()) {
                case "red":
                    cbRed.setChecked(false);
                    break;
                case "green":
                    cbGreen.setChecked(false);
                    break;
                case "blue":
                    cbBlue.setChecked(false);
                    break;
            }
        } else
            super.onBackPressed();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (buttonView.getId()) {
            case R.id.cbRed:
                manageFragment(isChecked, transaction, R.color.red, "red");
                break;
            case R.id.cbGreen:
                manageFragment(isChecked, transaction, R.color.green, "green");
                break;
            case R.id.cbBlue:
                manageFragment(isChecked, transaction, R.color.blue, "blue");
                break;
        }
        transaction.commit();
    }

    private void manageFragment(boolean isChecked, FragmentTransaction transaction, int color, String tag) {
        if (isChecked) {
            transaction.add(R.id.flForFragment, MyFragment.newInstance(ContextCompat.getColor(this, color)), tag);
            transaction.addToBackStack(tag);
        } else {
            transaction.remove(getSupportFragmentManager().findFragmentByTag(tag));
        }
    }
}
