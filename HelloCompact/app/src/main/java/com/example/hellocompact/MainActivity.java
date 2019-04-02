package com.example.hellocompact;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView helloTextview;
    private String[] warna = 	{"red",	"pink",	"purple",	"deep_purple",
            "indigo",	"blue",	"light_blue",	"cyan",	"teal",	"green",
            "light_green",	"lime",	"yellow",	"amber",	"orange",	"deep_orange",
            "brown",	"grey",	"blue_grey",	"black" };
    private TextView hello_baru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inisialisasi main text view
        helloTextview = (TextView) findViewById(R.id.hello_textview);
        hello_baru = (EditText) findViewById(R.id.set_text);
        //mengembalikan instan saved state ( text color)
        if(savedInstanceState != null){
            helloTextview.setTextColor(savedInstanceState.getInt("color"));
        }
    }
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        //menyimpan warna dasar text
        outState.putInt("color", helloTextview.getCurrentTextColor());
    }

    public void change(View view) {
        Random random = new Random();
        String colorName = warna[random.nextInt(20)];

        //mendaptkan identifikasi warna yang cocok dengan nama warna
        int colorResourceName = getResources().getIdentifier(colorName, "color",
                getApplicationContext().getPackageName());

        //mendapatkan id warna dari sumber
        int colorRes= ContextCompat.getColor(this, colorResourceName);

        //mengubah warna text
        helloTextview.setTextColor(colorRes);
        Log.d("MainActivity", " Warna berubah menjadi " + warna);


    }

    public void set(View view) {
        String sbc = hello_baru.getText().toString();
        if (helloTextview != null){
            helloTextview.setText(sbc);
            Log.d("MainActivity", "Text diubah menjadi " + sbc);
        }
    }
}
