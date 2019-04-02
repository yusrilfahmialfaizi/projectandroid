package com.example.scorekeeper;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";
    private int scorea, scoreb = 0;
    private TextView mScorea;
    private TextView mScoreb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScorea = (TextView) findViewById(R.id.score_a);
        mScoreb = (TextView) findViewById(R.id.score_b);

        if (savedInstanceState != null) {
            scorea = savedInstanceState.getInt(STATE_SCORE_1);
            scoreb = savedInstanceState.getInt(STATE_SCORE_2);

            mScorea.setText(String.valueOf(scorea));
            mScoreb.setText(String.valueOf(scoreb));
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.plus_a:
                scorea++;
                mScorea.setText(String.valueOf(scorea));
                break;
            case R.id.plus_b:
                scoreb++;
                mScoreb.setText(String.valueOf(scoreb));
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
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
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, scorea);
        outState.putInt(STATE_SCORE_2, scoreb);
        super.onSaveInstanceState(outState);
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.minus_a:
                scorea--;
                if (scorea <= 0) {
                    scorea = 0;
                    mScorea.setText(String.valueOf(scorea));
                } else {
                    mScorea.setText(String.valueOf(scorea));
                }
                break;
            case R.id.minus_b:
                scoreb--;
                if (scoreb <= 0) {
                    scoreb = 0;
                    mScoreb.setText(String.valueOf(scoreb));
                } else {
                    mScoreb.setText(String.valueOf(scoreb));
                }
        }
    }
}
