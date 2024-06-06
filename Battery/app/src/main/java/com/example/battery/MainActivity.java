package com.example.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ProgressBar p;
    TextView t;
    BroadcastReceiver b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        p = findViewById(R.id.progressBar);
        t = findViewById(R.id.textView);
        ConstraintLayout l1 =findViewById(R.id.main);
        b = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                t.setText(String.valueOf(level));
                p.setProgress(level);
                if(level>=80){
                    l1.setBackgroundColor(Color.GREEN);
                } else if (level>80 && level <=30) {
                    l1.setBackgroundColor(Color.YELLOW);

                }else if(level<30){
                    l1.setBackgroundColor(Color.RED);
                }
            }
        };


    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(b,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(b);
    }
}