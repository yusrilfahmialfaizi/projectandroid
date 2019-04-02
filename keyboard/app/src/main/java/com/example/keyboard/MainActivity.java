package com.example.keyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public	void	showText(View	view)	{
        EditText editText	=	(EditText)	findViewById(R.id.edit_Text);
        if	(editText	!=	null)	{
            String	showString	=	editText.getText().toString();
            Toast.makeText(this,	showString,	Toast.LENGTH_SHORT).show();
        }
    }

    public void showPass(View view) {
        EditText editPass = (EditText) findViewById(R.id.edit_Pass);
        if(editPass != null){
            String showString = editPass.getText().toString();
            Toast.makeText(this,showString,Toast.LENGTH_SHORT).show();
        }
    }

    public void showEmail(View view) {
        EditText editEmail	=	(EditText)	findViewById(R.id.edit_Email);
        if	(editEmail	!=	null)	{
            String	showString	=	editEmail.getText().toString();
            Toast.makeText(this,	showString,	Toast.LENGTH_SHORT).show();
        }
    }

    public void showPhone(View view) {
        EditText editPhone	=	(EditText)	findViewById(R.id.edit_phone);
        if	(editPhone	!=	null)	{
            String	showString	=	editPhone.getText().toString();
            Toast.makeText(this,	showString,	Toast.LENGTH_SHORT).show();
        }
    }
}
