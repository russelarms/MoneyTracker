package com.makweb.moneytracker;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    final String TAG="main activity";

    private Toolbar toolbar;


   /* private TextView txtHelloText;
    private Button btnShowToast;
    private CoordinatorLayout clayMainActivity;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();

     /*   clayMainActivity = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        txtHelloText = (TextView)findViewById(R.id.textHello);
        btnShowToast = (Button)findViewById(R.id.button);
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(clayMainActivity, "my first snack", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });*/

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        Log.d(TAG, "MainActivity: onCreateView()");
        return super.onCreateView(name, context, attrs);
    }

    private  void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24px);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
