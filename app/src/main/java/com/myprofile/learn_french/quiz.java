package com.myprofile.learn_french;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class quiz extends AppCompatActivity {
    //initalising pos //
    int pos;
    //initialising variable containing the score //
    int score;
    // initialising list  containing the answers(animals)//
    String[] answers = {"cochon","mouton","abeille","cheval","grenouille","lapin","mouton","poulet","souris","taureau","tortue","vache","ane"};
    // initialising the list containing the drawabels//
    int[] images={R.drawable.cochon,R.drawable.mouton,R.drawable.abeille,R.drawable.cheval,R.drawable.grenouille,R.drawable.lapin,R.drawable.mouton,R.drawable.poulet,R.drawable.souris,R.drawable.taureau,R.drawable.tortue,R.drawable.vache,R.drawable.ane};
    //initialising the imageview//
    ImageView img;
    //initialising textview of the score//
    TextView score_txt;
    // initialising the buttons //
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    // intialising buttons_variables containing if the answer is false or right//
    Boolean bt_1;
    Boolean bt_2;
    Boolean bt_3;
    Boolean bt_4;
    //initialising the Timer to schedule tasks//
    Timer timer=new Timer();
    // function that makes the answers random expect the right one_beta //

    private void fixbuttons(Button bt_t,Button bt_2,Button bt_3,Button bt_4){
        bt_t.setText(answers[pos]);
        Random rand = new Random();
        int rand_int1 = rand.nextInt(4);
        bt_2.setText(answers[(pos+rand_int1+1)%answers.length]);
        int rand_int2 = rand.nextInt(4);
        bt_3.setText(answers[(pos+rand_int2+5)%answers.length]);
        int rand_int3 = rand.nextInt(4);
        bt_4.setText(answers[(pos+rand_int3+9)%answers.length]);

    }
    //fix on click buttons based on button_answer boolean//
    private void onclick() {

        button_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button//
                if (bt_1) {
                    Toast.makeText(getApplicationContext(), "good job right answer! score+1", Toast.LENGTH_SHORT);

                    score++;
                    button_1.setTextColor(Color.GREEN);


                } else {
                    Toast.makeText(getApplicationContext(), "Wrong answer.", Toast.LENGTH_SHORT);
                    button_1.setTextColor(Color.RED);
                }
                if (bt_2) {
                    button_2.setTextColor(Color.GREEN);
                }
                if (bt_3) {
                    button_3.setTextColor(Color.GREEN);
                }
                if (bt_4) {
                    button_4.setTextColor(Color.GREEN);
                }
                pos++;
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        main(pos);
                    }
                }, 1000);


            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button//
                if (bt_2) {
                    Toast.makeText(getApplicationContext(), "good job right answer! score+1", Toast.LENGTH_SHORT);

                    score++;
                    button_2.setTextColor(Color.GREEN);


                } else {
                    Toast.makeText(getApplicationContext(), "Wrong answer.", Toast.LENGTH_SHORT);
                    button_2.setTextColor(Color.RED);
                }
                if (bt_1) {
                    button_1.setTextColor(Color.GREEN);
                }
                if (bt_3) {
                    button_3.setTextColor(Color.GREEN);
                }
                if (bt_4) {
                    button_4.setTextColor(Color.GREEN);
                }
                pos++;
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        main(pos);
                    }
                }, 1000);



            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button//
                if (bt_3) {
                    Toast.makeText(getApplicationContext(), "good job right answer! score+1", Toast.LENGTH_SHORT);

                    score++;
                    button_3.setTextColor(Color.GREEN);


                } else {
                    Toast.makeText(getApplicationContext(), "Wrong answer.", Toast.LENGTH_SHORT);
                    button_3.setTextColor(Color.RED);
                }
                if (bt_2) {
                    button_2.setTextColor(Color.GREEN);
                }
                if (bt_1) {
                    button_1.setTextColor(Color.GREEN);
                }
                if (bt_4) {
                    button_4.setTextColor(Color.GREEN);
                }
                pos++;
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        main(pos);
                    }
                }, 1000);


            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button//
                if (bt_4) {
                    Toast.makeText(getApplicationContext(), "good job right answer! score+1", Toast.LENGTH_SHORT);

                    score++;
                    button_4.setTextColor(Color.GREEN);


                } else {
                    Toast.makeText(getApplicationContext(), "Wrong answer.", Toast.LENGTH_SHORT);
                    button_4.setTextColor(Color.RED);
                }
                if (bt_2) {
                    button_2.setTextColor(Color.GREEN);
                }
                if (bt_3) {
                    button_3.setTextColor(Color.GREEN);
                }
                if (bt_1) {
                    button_1.setTextColor(Color.GREEN);
                }
                pos++;
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        main(pos);
                    }
                }, 1000);


            }
        });
    }
    // change the button_answer_boolean to right or wrong based on the given right answer as an int //
    private void changebuttons(int i){
        if (i==1) {
            bt_1=true;
            bt_2=false;
            bt_3=false;
            bt_4=false;

        }
        if (i==2) {
            bt_1=false;
            bt_2=true;
            bt_3=false;
            bt_4=false;

        }
        if (i==3) {
            bt_1=false;
            bt_2=false;
            bt_3=true;
            bt_4=false;

        }
        if (i==4) {
            bt_1=false;
            bt_2=false;
            bt_3=false;
            bt_4=true;

        }





    }
    // make all button_answer_boolean false and background back to default//
    private void falsebuttons(){
        bt_1=false;
        button_1.setTextColor(Color.BLACK);
        bt_2=false;
        button_2.setTextColor(Color.BLACK);
        bt_3=false;
        button_3.setTextColor(Color.BLACK);
        bt_4=false;
        button_4.setTextColor(Color.BLACK);

    }
    // a function that convert any number to a string//
    public static String to_string(int Number){
        return Integer.toString(Number);
    }
    private void main(int i){
        if (i==answers.length){
            change_activity();

        }
        else{
            runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // Stuff that updates the UI//
                score_txt.setText("score: "+to_string(score));
                img.setImageResource(images[pos]);
                falsebuttons();
                Random rand = new Random();
                int rand_int = rand.nextInt(4) + 1;
                changebuttons(rand_int);
                if (rand_int == 1) {
                    fixbuttons(button_1, button_2, button_3, button_4);
                }
                if (rand_int == 2) {
                    fixbuttons(button_2, button_1, button_3, button_4);
                }
                if (rand_int == 3) {
                    fixbuttons(button_3, button_2, button_1, button_4);
                }
                if (rand_int == 4) {
                    fixbuttons(button_4, button_2, button_3, button_1);
                }
                onclick();
            }});}





    }
    // change activity function + clearing previous one //
    // reason is : the bug when i click multiple times on the button and the activity is opened multiple times//
    private void change_activity(){
        if (shared.score <score){
            shared.score= score;}
        Log.i("score", to_string(shared.score));
        Intent intent=new Intent(this,chooselevel.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
    // overriding  back button//
    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent intent = new Intent(this,chooselevel.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        img= (ImageView) findViewById(R.id.imageView);
        score_txt= (TextView) findViewById(R.id.score);
        pos=0;
        score=0;
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        main(pos);



    }

}