package com.example.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Provider;

public class Myservice extends Service {
    MediaPlayer music;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();
        music = MediaPlayer.create(this,R.raw.a);
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        music.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        music.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
