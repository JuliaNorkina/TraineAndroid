package com.example.nativecamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {

    private final int REQUEST_CODE = 1;
    private ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        Button bPhoto = findViewById(R.id.bPhoto);
        ivPhoto = findViewById(R.id.ivPhoto);

        bPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle bndl = data.getExtras();
            if (bndl != null) {
                Object obj = data.getExtras().get("data");
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    ivPhoto.setImageBitmap(bitmap);
                }
            }
        }
    }
}
