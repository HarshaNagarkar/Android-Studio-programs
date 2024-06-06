package com.example.databasecl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,usn,phn,call;
    Button insert,cl;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextText);
        usn = findViewById(R.id.editTextText2);
        phn = findViewById(R.id.editTextText3);
        call = findViewById(R.id.editTextText4);
        insert = findViewById(R.id.button);
        cl = findViewById(R.id.button2);
        insert.setOnClickListener(this);
        cl.setOnClickListener(this);

    }

    @SuppressLint("Range")
    @Override
    public void onClick(View v) {
        String na,us,pn,ucl;
        na= name.getText().toString();
        us= usn.getText().toString();
        pn = phn.getText().toString();
        try{
            db=this.openOrCreateDatabase("Sam",MODE_PRIVATE,null);
            db.execSQL("create table if not exists Student(USN varchar(20),Name varchar(20),Phn varchar(20))");
            if(v.getId()==insert.getId()){
                db.execSQL("insert into Student values('"+na+"','"+us+"','"+pn+"')");
                Toast.makeText(this,"Inserted",Toast.LENGTH_LONG).show();
            }
            if(v.getId()==cl.getId()){
                Cursor c = db.rawQuery("select * from Student where USN = '"+call.getText().toString()+"';",null);
                if(c.getCount()!=1){
                    Toast.makeText(this,"invalid",Toast.LENGTH_LONG).show();
                }
                else{
                    if(c.moveToNext()){
                        pn = c.getString(c.getColumnIndex("Phn"));
                        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+pn));
                        startActivity(i);
                    }
                }
            }
        }catch (SQLException e){
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        }finally {
            if(db!=null){
                db.close();
            }
        }
    }
}