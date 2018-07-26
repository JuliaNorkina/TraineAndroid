package com.example.twoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInfo;
    public static final String CUSTOMERS_DATA = "Customers data";
    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        tvInfo = findViewById(R.id.tvInfo);
        Button bEnterData = findViewById(R.id.bEnterData);

        bEnterData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            ArrayList<Customer> customers = data.getParcelableArrayListExtra(CUSTOMERS_DATA);
            tvInfo.setText(customers.toString().replace("[", "").replace("]", "").replace(",", ""));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
