package com.example.resume;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE =1 ;
    Button save,upload;
    EditText n,q,e;
    RadioGroup r;
    RadioButton male,female;
    ImageView img;
    Bitmap ibit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.button2);
        upload = findViewById(R.id.button);
        n = findViewById(R.id.editTextText);
        e = findViewById(R.id.editTextText2);
        q = findViewById(R.id.editTextText3);
        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);
        img = findViewById(R.id.imageView);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname,uemail,uqual,ugen;
                uname = n.getText().toString();
                uemail = e.getText().toString();
                uqual = e.getText().toString();
                ugen = male.isChecked() ?"male":"female";
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("Name",uname);
                i.putExtra("Email",uemail);
                i.putExtra("Qual",uqual);
                i.putExtra("Gen",ugen);
                i.putExtra("Image",ibit);
                startActivity(i);
            }
        });
        upload.setOnClickListener(v -> dispatch());

    }

    private void dispatch() {
        Intent photo = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        photo.setType("image/*");
        startActivityForResult(photo,REQUEST_IMAGE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            try{
                Uri selectedImage = data.getData();
                Bitmap originalBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap,200,200,false);
                ibit = resizedBitmap;
                img.setImageBitmap(ibit);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}