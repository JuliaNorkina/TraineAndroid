package com.example.nativecamera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener {

    private final String EMAIL_ADDRESS = "yulia.norkina2@gmail.com";
    public final String SUBJECT = "subject";
    private final String LETTERS_TEXT = "This is new letter from Julia Norkina";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);

        Button bEmail = findViewById(R.id.bEmail);
        Button bShare = findViewById(R.id.bShare);
        Button bPhone = findViewById(R.id.bPhone);

       setAllOnClickListener(this, bEmail, bPhone, bShare);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bEmail:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, EMAIL_ADDRESS);
                intent.putExtra(Intent.EXTRA_SUBJECT, SUBJECT);
                intent.putExtra(Intent.EXTRA_TEXT, LETTERS_TEXT);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Choose App:"));
                break;
            case R.id.bShare:
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                startActivity(Intent.createChooser(intent2,"Choose App:"));
                break;
            case R.id.bPhone:
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                startActivity(intent1);
        }
    }

    public static void setAllOnClickListener(View.OnClickListener onClickListener, View... views) {
        for (View view : views) {
            view.setOnClickListener(onClickListener);
        }
    }
}
