package com.example.duaaktivitas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            SecondActivity.class.getSimpleName();

    public static final String EXTRA_REPLY =
            "com.example.android.duaaktivitas.extra.REPLY";

    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = (EditText) findViewById(R.id.editText_second);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.text_message);

        textView.setText(message);

    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();

        Intent intentReply = new Intent();
        intentReply.putExtra(EXTRA_REPLY, reply);

        setResult(RESULT_OK, intentReply);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
    }
}
