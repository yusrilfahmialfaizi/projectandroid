package com.example.score;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     int score1,score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayScore1(int score){
        TextView viewscore = (TextView) findViewById(R.id.team_a);
        viewscore.setText(String.valueOf(score));
    }

    public void tree_a(View view) {
        score1 = score1 +3;
        displayScore1(score1);
        Log.d("MainActivity","Indonesia Get score +3");
    }

    public void two_a(View view) {
        score1 = score1 +2;
        displayScore1(score1);
        Log.d("MainActivity","Indonesia Get score +2");
    }

    public void free_a(View view) {
        score1 = score1 +1;
        displayScore1(score1);
        Log.d("MainActivity","Indonesia Get score +1");
    }

    public void displayScore2(int score2){
        TextView viewscore2 = (TextView) findViewById(R.id.team_b);
        viewscore2.setText(String.valueOf(score2));
    }

    public void tree_b(View view) {
        score2 = score2 + 3;
        displayScore2(score2);
        Log.d("MainActivity","Philipines Get score +3");
    }

    public void two_b(View view) {
        score2 = score2 + 2;
        displayScore2(score2);
        Log.d("MainActivity","Philipines Get score +2");
    }

    public void free_b(View view) {
        score2 = score2 + 1;
        displayScore2(score2);
        Log.d("MainActivity","Philipines Get score +1");
    }
    public void reset(View view) {
            score1 = 0;
            TextView viewscore1 = (TextView) findViewById(R.id.team_a);
            viewscore1.setText(String.valueOf(score1));
            score2 = 0;
            TextView viewscore3 = (TextView) findViewById(R.id.team_b);
            viewscore3.setText(String.valueOf(score2));

    }
}
