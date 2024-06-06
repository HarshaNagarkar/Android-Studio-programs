package com.example.resume;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
TextView name,email,gender,qual;
ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.textView);
        email = findViewById(R.id.textView2);
        gender = findViewById(R.id.textView3);
        qual = findViewById(R.id.textView4);
        imgv =findViewById(R.id.imageView3);

        Intent i = getIntent();
        if(i!=null){
            String na,em,ge,qa;
            na = i.getStringExtra("Name");
            em = i.getStringExtra("Email");
            ge = i.getStringExtra("Gen");
            qa = i.getStringExtra("Qual");
            Bitmap im = i.getParcelableExtra("Image");
            name.setText(na);
            email.setText(em);
            gender.setText(ge);
            qual.setText(qa);
            runOnUiThread(()->{
                if(im != null){
                    imgv.setImageBitmap(im);
                }else {
                    imgv.setVisibility(View.GONE);
                }
            });
        }

    }
}