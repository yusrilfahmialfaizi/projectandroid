package com.example.keeper;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mScoreA;
    private TextView mScoreB;
    private int scorea,scoreb = 0;
    static final String STATE_SCORE_1 = "Team Score A";
    static final String STATE_SCORE_2 = "Team Score B";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreA = (TextView) findViewById(R.id.scorea);
        mScoreB = (TextView) findViewById(R.id.scoreb);

        //set score text view
        mScoreA.setText(String.valueOf(scorea));
        mScoreB.setText(String.valueOf(scoreb));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int night_Mode = AppCompatDelegate.getDefaultNightMode();
            if (night_Mode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void increase(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.Plus_a:
                scorea++;
                mScoreA.setText(String.valueOf(scorea));
                break;
            case R.id.Plus_b:
                scoreb++;
                mScoreB.setText(String.valueOf(scoreb));
        }
    }

    public void decrease(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.Minus_a:
                scorea--;
                if (scorea <=0){
                    scorea = 0;
                    mScoreA.setText(String.valueOf(scorea));
                }else {
                    mScoreA.setText(String.valueOf(scorea));
                }
                break;
            case R.id.Minus_b:
                scoreb--;
                if (scoreb <=0){
                    scoreb = 0;
                    mScoreB.setText(String.valueOf(scoreb));
                }else {
                    mScoreB.setText(String.valueOf(scoreb));
                }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, scorea);
        outState.putInt(STATE_SCORE_2, scoreb);
        super.onSaveInstanceState(outState);

    }
}
