package com.makweb.moneytracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    final String TAG="main activity";
    private TextView txtHelloText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHelloText = (TextView)findViewById(R.id.textHello);
        Log.d(TAG, "MainActivity: onCreate()");
    }

    @Override
    protected void onStart (){
        super.onStart();
        Log.d(TAG,"MainActivity: onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }
}
