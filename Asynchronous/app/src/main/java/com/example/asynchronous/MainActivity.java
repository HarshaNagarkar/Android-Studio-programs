package com.example.asynchronous;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ProgressBar p;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        t1 =findViewById(R.id.textView);
        Button b1 = findViewById(R.id.button);
        p =findViewById(R.id.progressBar);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T a1 =new T();
                a1.execute("10");
            }
        });
    }
    class T extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            int max = Integer.parseInt(strings[1]);
            int i = 0;
            while(i<max){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();

                }
                i++;
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            p.setProgress(values[0]);
            t1.setText(values[0].toString());
            super.onProgressUpdate(values);
        }
    }
}