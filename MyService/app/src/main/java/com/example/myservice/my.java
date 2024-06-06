package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class my extends Service {

    MediaPlayer m;

    @Override
    public void onCreate() {
        super.onCreate();
        m = MediaPlayer.create(this,R.raw.a);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        m.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        m.stop();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
