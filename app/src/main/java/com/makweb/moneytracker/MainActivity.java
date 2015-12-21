package com.makweb.moneytracker;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    final String TAG = "main activity";

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private CoordinatorLayout coordinatorLayout;
    private BaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_container);

        setupToolbar();
        setupDrawer();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new ExpensesFragment()).commit();
        }
        Log.d(TAG, "MainActivity: onCreate()");


    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24px);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_expenses:
                        fragment = new ExpensesFragment();
                        navigationView.getMenu().findItem(R.id.drawer_expenses).setChecked(true);
                        break;
                    case R.id.drawer_categories:
                        fragment = new CategoryFragment();
                        navigationView.getMenu().findItem(R.id.drawer_categories).setChecked(true);
                        break;
                    case R.id.drawer_statistics:
                        fragment = new StatisticFragment();
                        navigationView.getMenu().findItem(R.id.drawer_statistics).setChecked(true);
                        break;
                    case R.id.drawer_settings:
                        fragment = new SettingFragment();
                        navigationView.getMenu().findItem(R.id.drawer_settings).setChecked(true);
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).addToBackStack(null).commit();

                item.setChecked(true);
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        BaseFragment findingFragment = (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.main_frame);
        if (findingFragment != null && findingFragment instanceof ExpensesFragment) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }


        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
        }

    }

    public  void onFragmentReady(BaseFragment fragment){
        Snackbar.make(fragment.getView(), fragment.getTitle(), Snackbar.LENGTH_SHORT).show();
    }


}
