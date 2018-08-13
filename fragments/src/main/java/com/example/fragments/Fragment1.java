package com.example.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {

    private Button button;
    private OnSomeEventListener onSomeEventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onSomeEventListener = (OnSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, null);

        button = v.findViewById(R.id.bSend1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onSomeEventListener.someEvent(button);
            }
        });
        return v;
    }
}