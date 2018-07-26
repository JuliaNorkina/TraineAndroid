package com.example.twoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String CUSTOMERS_DATA = "Customers data";
    private EditText etFio, etAge, etCash;
    private ArrayList<Customer> customers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        etFio = findViewById(R.id.etFio);
        etAge = findViewById(R.id.etAge);
        etCash = findViewById(R.id.etCash);
        Button bSave = findViewById(R.id.bSave);
        Button bOk = findViewById(R.id.bOk);

        bSave.setOnClickListener(this);
        bOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSave:
                Validator validator = new Validator().valid(etFio.getText().toString(),etAge.getText().toString(),etCash.getText().toString());

                if (!validator.isFio()){
                    etFio.setError("FIO can`t be empty");
                } else if (!validator.isAge()) {
                    etAge.setError("Age can`t be empty");
                } else if (!validator.isCash()){
                    etCash.setError("Cash can`t be empty");
                } else {
                    Customer customer = new Customer(etFio.getText().toString(), Integer.parseInt(etAge.getText().toString()), Integer.parseInt(etCash.getText().toString()));
                    customers.add(customer);
                    etFio.setText("");
                    etAge.setText("");
                    etCash.setText("");
                }
                break;
            case R.id.bOk:
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra(CUSTOMERS_DATA, customers);
                setResult(RESULT_OK, intent);
                finish();
        }
    }
}
