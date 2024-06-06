package com.example.webview;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    WebView we;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        we = findViewById(R.id.we);
        we.setWebViewClient(new WebViewClient());
        Intent i = getIntent();
        String url = i.getStringExtra("load");
        if(url.equals("default")){
            we.loadUrl("https://lms.nmamit.in/login/index.php");
        }
        else {
            we.loadUrl(url);
        }

    }
}