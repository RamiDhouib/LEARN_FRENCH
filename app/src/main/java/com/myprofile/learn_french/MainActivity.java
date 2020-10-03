package com.myprofile.learn_french;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    int length;


    private void clickbuttons() {
        final ImageButton button = findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button start Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, chooselevel.class);
                startActivity(intent);
            }
        });
        final ImageButton button1 = findViewById(R.id.sound);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button sound Clicked", Toast.LENGTH_SHORT).show();
                if (player.isPlaying()) {
                    length=player.getCurrentPosition();

                    player.pause();

            }
                else{
                   player.seekTo(length);
                    player.start();
                }
            }

        });

        final ImageButton button2 = findViewById(R.id.exit);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Exiting app", Toast.LENGTH_SHORT).show();
                player.release();
                finish();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickbuttons();
        player= MediaPlayer.create(this,R.raw.background_music);
        player.setLooping(true);
        player.start();
    }}


