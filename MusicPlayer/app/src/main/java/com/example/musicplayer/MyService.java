package com.example.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.musicplayer.databinding.ActivityMainBinding;

public class MyService extends Service {
    MediaPlayer myMusic;

    ActivityMainBinding binding;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myMusic = MediaPlayer.create(MyService.this, R.raw.end_of_beginning);
        myMusic.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (myMusic.isPlaying()) {
            myMusic.pause();
        } else {
            myMusic.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myMusic.stop();
    }

}