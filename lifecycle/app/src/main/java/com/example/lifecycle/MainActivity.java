package com.example.lifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Life Cycle","on start msg");
        Toast.makeText(MainActivity.this,"on start",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Life Cycle","on Resume msg");
        Toast.makeText(MainActivity.this,"on Resume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Life Cycle","on Pause msg");
        Toast.makeText(MainActivity.this,"on Pause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life Cycle","on Stop msg");
        Toast.makeText(MainActivity.this,"on Stop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Life Cycle","on Destroy");
        Toast.makeText(MainActivity.this,"on Destroy",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Life Cycle","on Restart");
        Toast.makeText(MainActivity.this,"on Restart",Toast.LENGTH_LONG).show();
    }
}