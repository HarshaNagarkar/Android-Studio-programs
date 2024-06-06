package com.example.sms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText phn,msg;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        phn = findViewById(R.id.editTextText);
        msg = findViewById(R.id.editTextText2);
        b1 =findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num,message;
                num = phn.getText().toString();
                message = msg.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+num));
                i.putExtra("sms_body",message);
                startActivity(i);

            }
        });

    }
}