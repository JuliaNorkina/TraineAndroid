package com.example.checkboxwithfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.color_fragment, null);
        return view;
    }

    public void setFragmentBackground(int color) {
        view.setBackgroundColor(color);
    }
}


