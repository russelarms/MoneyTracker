package com.makweb.moneytracker;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    final String TAG="main activity";
    private TextView txtHelloText;
    private Button btnShowToast;
    private CoordinatorLayout clayMainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clayMainActivity = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        txtHelloText = (TextView)findViewById(R.id.textHello);
        btnShowToast = (Button)findViewById(R.id.button);
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(clayMainActivity, "my first snack", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

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
