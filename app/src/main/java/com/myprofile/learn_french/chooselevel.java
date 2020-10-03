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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class chooselevel extends AppCompatActivity {
    TextView score_txt;
    //changing textview to newest best score//
    private void fixscore(){
        score_txt.setText("score :"+quiz.to_string(shared.score)
        );
        Log.i("shared_score", quiz.to_string(shared.score));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooselevel);
        score_txt=(TextView) findViewById(R.id.score);
        fixscore();

        final Button animals = findViewById(R.id.animals);
        animals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(chooselevel.this,quiz.class);
                finish();
                startActivity(intent);
            }
        });


}}