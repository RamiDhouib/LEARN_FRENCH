package com.myprofile.learn_french;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class intro extends AppCompatActivity {
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        timer = new Timer();
        final MediaPlayer player=MediaPlayer.create(this,R.raw.disguisedpanda);
        player.start();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(intro.this ,MainActivity.class);
                startActivity(intent);
                player.release();
                finish();
            }
        }, 5000);
    }
}