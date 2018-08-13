package com.example.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements OnSomeEventListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.flFrg1, fragment1);
        transaction.add(R.id.flFrg2, fragment2);
        transaction.commit();
    }

    @Override
    public void someEvent(View view) {
        switch (view.getId()) {
            case R.id.bSend1:
                Fragment fragment2 = getFragmentManager().findFragmentById(R.id.flFrg2);
                String s = ((EditText) getFragmentManager().findFragmentById(R.id.flFrg1).getView().findViewById(R.id.etFirst)).getText().toString();
                ((TextView) fragment2.getView().findViewById(R.id.tvSecond)).setText(s);
                break;
            case R.id.bSend2:
                fragment2 = getFragmentManager().findFragmentById(R.id.flFrg2);
                ((TextView) fragment2.getView().findViewById(R.id.tvSecond)).setText(R.string.frg2_present);
                break;
        }
    }
}
