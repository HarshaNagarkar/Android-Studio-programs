package com.example.sharedpreferance;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1,e2,e3;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    public static final String MyPrefs = "MyPrefs";
    public static final String Name = "Namekey";
    public static final String Phone = "Phonekey";
    public static final String Email = "Emailkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1 =findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 =findViewById(R.id.button3);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        e3 = findViewById(R.id.editTextText3);
        sp = getSharedPreferences(MyPrefs,MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,phone,email;
                name = e1.getText().toString();
                phone = e2.getText().toString();
                email = e3.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(Name,name);
                editor.putString(Phone,phone);
                editor.putString(Email,email);
                editor.commit();
                Toast.makeText(MainActivity.this,"thanks",Toast.LENGTH_LONG).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed = sp.edit();
                ed.clear();
                ed.commit();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "name "+sp.getString(Name,null)+" Email "+sp.getString(Email,null)+" Phone "+sp.getString(Phone,null);
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }
        });
    }
}