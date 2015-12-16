package com.makweb.moneytracker;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    final String TAG="main activity";

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private CoordinatorLayout coordinatorLayout;
    //private ListView expensesListView;
    private  ExpenseAdapter expenseAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView expensesListView = (ListView) findViewById(R.id.list_view);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_container);

        List<Expense> adapterData = getDataList();
        expenseAdapter=new ExpenseAdapter(this, adapterData);
        expensesListView.setAdapter(expenseAdapter);
        setupToolbar();
        setupDrawer();
        Log.d(TAG, "MainActivity: onCreate()");

    }

    @Override
    protected void onStart (){
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
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
        //toolbar.setTitleTextColor('#000000');
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24px);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupDrawer(){
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView=(NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Snackbar.make(coordinatorLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    private List<Expense> getDataList(){
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("Phone","1000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        return data;
    }
}
