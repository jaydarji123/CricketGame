package com.example.cricket_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class play extends AppCompatActivity {

    public TextView player1,player2,status,run,wicket1,wicket2,score1,score2,ball1,ball2,over1,over2;
    public Button reset,play,back;
    public int s1=0,s2=0,w1=0,w2=0,b1=0,b2=0,o1=0,o2=0;
    public Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        getSupportActionBar().setTitle("Cricket");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        player1 = (TextView) findViewById(R.id.player1);
        player2 = (TextView) findViewById(R.id.player2);
        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        status = (TextView) findViewById(R.id.needs);
        wicket1 = (TextView) findViewById(R.id.wkt1);
        wicket2 = (TextView) findViewById(R.id.wkt2);
        ball1 = (TextView) findViewById(R.id.ball1);
        ball2 = (TextView) findViewById(R.id.ball2);
        over1 = (TextView) findViewById(R.id.over1);
        over2 = (TextView) findViewById(R.id.over2);
        run = (TextView) findViewById(R.id.runs);
        reset = (Button) findViewById(R.id.reset);
        play = (Button) findViewById(R.id.play);
        back = (Button) findViewById(R.id.back);

        String nam1 = getIntent().getStringExtra("keyname1");
        String nam2 = getIntent().getStringExtra("keyname2");

        player1.setText(nam1);
        player2.setText(nam2);
        status.setText(nam1+" is playing");

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Randomnumber = random.nextInt(8) + 1;

                if(b1<5) {
                    if (Randomnumber == 7) {
                        ball1.setText(Integer.toString(b1));
                    } else {
                        b1++;
                        ball1.setText(Integer.toString(b1));
                    }
                }
                else{
                    if(o1<1) {
                        if (Randomnumber == 7) {
                            ball1.setText(Integer.toString(b1));
                            over1.setText(Integer.toString(o1));
                        } else {
                            b1 = 0;
                            ball1.setText(Integer.toString(b1));
                            o1++;
                            over1.setText(Integer.toString(o1));
                        }
                    }
                    else {
                        over1.setText(Integer.toString(o1+1));
                        ball1.setText("0");
                        play.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int s3 = s1 + 1;
                                status.setText("Target is " + s3);
                                playd();
                            }
                        });
                    }
                }

                switch (Randomnumber) {
                    case 1:
                        run.setText("1");
                        s1 = s1 + 1;
                        score1.setText(Integer.toString(s1));
                        break;
                    case 2:
                        run.setText("2");
                        s1 = s1 + 2;
                        score1.setText(Integer.toString(s1));
                        break;
                    case 3:
                        run.setText("3");
                        s1 = s1 + 3;
                        score1.setText(Integer.toString(s1));
                        break;
                    case 4:
                        run.setText("4");
                        s1 = s1 + 4;
                        score1.setText(Integer.toString(s1));
                        break;
                    case 5:
                        run.setText("W");
                        w1 = w1 + 1;
                        wicket1.setText(Integer.toString(w1));
                        if(w1>=10) {
                            int s3 = s1 + 1;
                            status.setText("Target is " + s3);
                            play.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    playd();

                                }
                            });
                        }
                        break;

                    case 6:
                        run.setText("6");
                        s1 = s1 + 6;
                        score1.setText(Integer.toString(s1));
                        break;
                    case 7:
                        run.setText("wd");
                        s1 = s1 + 1;
                        score1.setText(Integer.toString(s1));
                        break;
                    case 8:
                        run.setText("0");
                        score1.setText(Integer.toString(s1));
                        break;
                }
            }
            public void playd() {
                int Randomn = random.nextInt(8) + 1;
                int w3=10-w2;

                switch (Randomn) {
                    case 1:
                        run.setText("1");
                        s2 = s2 + 1;
                        score2.setText(Integer.toString(s2));
                        if (s1 < s2) {
                            status.setText(nam2+" Win by "+w3+" Wickets");
                            play.setEnabled(false);
                        }
                        break;
                    case 2:
                        run.setText("2");
                        s2 = s2 + 2;
                        score2.setText(Integer.toString(s2));
                        if (s1 < s2) {
                            status.setText(nam2+" Win by "+w3+" Wickets");
                            play.setEnabled(false);
                        }
                        break;
                    case 3:
                        run.setText("3");
                        s2 = s2 + 3;
                        score2.setText(Integer.toString(s2));
                        if (s1 < s2) {
                            status.setText(nam2+" Win by "+w3+" Wickets");
                            play.setEnabled(false);
                        }
                        break;
                    case 4:
                        run.setText("4");
                        s2 = s2 + 4;
                        score2.setText(Integer.toString(s2));
                        if (s1 < s2) {
                            status.setText(nam2+" Win by "+w3+" Wickets");
                            play.setEnabled(false);
                        }
                        break;
                    case 5:
                        run.setText("W");
                        w2 = w2 + 1;
                        wicket2.setText(Integer.toString(w2));
                        if (w2 >= 10) {
                            if (s1 == s2) {
                                status.setText("Match tied");
                                play.setEnabled(false);
                            } else {
                                int s4 = s1 - s2;
                                status.setText(nam1+" Win by " + s4 + " runs");
                                play.setEnabled(false);
                            }
                        }
                        break;
                    case 6:
                        run.setText("6");
                        s2 = s2 + 6;
                        score2.setText(Integer.toString(s2));
                        if (s1 < s2) {
                            status.setText(nam2+" Win by "+w3+" Wickets");
                            play.setEnabled(false);
                        }
                        break;
                    case 7:
                        run.setText("wd");
                        s2 = s2 + 1;
                        score2.setText(Integer.toString(s2));
                        if (s1 < s2) {
                            status.setText(nam2+" Win by "+w3+" Wickets");
                            play.setEnabled(false);
                        }
                        break;
                    case 8:
                        run.setText("0");
                        score2.setText(Integer.toString(s2));
                        if (s1 < s2) {
                            status.setText(nam2+" Win by "+w3+" Wickets");
                            play.setEnabled(false);
                        }
                        break;
                }
                if(b2<5){
                    if(Randomn==7){
                        ball2.setText(Integer.toString(b2));
                    }
                    else {
                        b2++;
                        ball2.setText(Integer.toString(b2));
                    }
                }
                else{
                    if(o2<1) {
                        if (Randomn == 7) {
                            ball2.setText(Integer.toString(b2));
                            over2.setText(Integer.toString(o2));
                        } else {
                            b2 = 0;
                            ball2.setText(Integer.toString(b2));
                            o2++;
                            over2.setText(Integer.toString(o2));
                        }
                    }
                    else {
                        over2.setText(Integer.toString(o2+1));
                        ball2.setText("0");
                        if(s1 < s2){
                            status.setText(nam2+" win by "+w3+" Wickets");
                        }
                        else if(s1 == s2){
                            status.setText("Match Tied");
                        }
                        else {
                            int s4 = s1 - s2;
                            status.setText(nam1+" Win by "+s4+" Runs");
                        }
                        play.setEnabled(false);
                    }
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setEnabled(true);
                score1.setText("0");
                score2.setText("0");
                wicket1.setText("0");
                wicket2.setText("0");
                over1.setText("0");
                over2.setText("0");
                ball1.setText("0");
                ball2.setText("0");
                run.setText("0");
                s1=0;
                s2=0;
                w1=0;
                w2=0;
                b1=0;
                b2=0;
                o1=0;
                o2=0;
                Toast.makeText(play.this ,"Created by Jayesh", Toast.LENGTH_LONG).show();
                finish();
                startActivity(getIntent());
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
