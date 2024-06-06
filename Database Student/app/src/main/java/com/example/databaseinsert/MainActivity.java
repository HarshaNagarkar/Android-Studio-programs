package com.example.databaseinsert;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText na, ag, add;
    TextView t1;
    Button insert, display;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        na = findViewById(R.id.editTextText);
        ag = findViewById(R.id.editTextText2);
        add = findViewById(R.id.editTextText3);
        t1 = findViewById(R.id.textView);
        insert = findViewById(R.id.button);
        display = findViewById(R.id.button2);

        insert.setOnClickListener(this);

        display.setOnClickListener(this);


    }

    @SuppressLint("Range")
    @Override
    public void onClick(View v) {
        String name, age, address;
        name = na.getText().toString();
        age = ag.getText().toString();
        address = add.getText().toString();

        try {
            db = openOrCreateDatabase("Sample", MODE_PRIVATE, null);
            db.execSQL("create table if not exists TEST(Name varchar(20),Age varchar(20),Address varchar(20)) ");
            if(v.getId() == insert.getId()) {
                db.execSQL("Insert into TEST values ('" + name + "','" + age + "','" + address + "')");
                Toast.makeText(MainActivity.this, "inserted", Toast.LENGTH_LONG).show();
            }
            if(v.getId() == display.getId()){
                String msg = "Name\tAge\tAdress";
                Cursor c = db.rawQuery("select * from TEST", null);
                if (c != null) {
                    if (c.moveToFirst()) {
                        do {
                            name = c.getString(c.getColumnIndex("Name"));
                            age = c.getString(c.getColumnIndex("Age"));
                            address = c.getString(c.getColumnIndex("Address"));
                            msg = msg+"\n" + name + "\t\t" + age + "\t" + address;
                        } while (c.moveToNext());
                    }
                    t1.setText(msg);
                }
            }

        } catch (SQLException e) {
            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_LONG).show();
        } finally {
            if (db != null) {
                db.close();
            }
        }

        }


    }