package com.example.datepicker;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
DatePicker dp;
Spinner sp;
ArrayAdapter ad;
String s1,date;
String s2[] = {"EC","CSE", "ME"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.D);
        sp = findViewById(R.id.spin);
        sp.setOnItemSelectedListener(this);
        ad = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,s2);
        sp.setAdapter(ad);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        s1 = ad.getItem(position).toString();
        date = dp.getDayOfMonth()+"-"+(dp.getMonth()+1)+"-"+dp.getYear();
        Toast.makeText(getApplicationContext(),"Joined On "+date+" Branch "+s1,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}