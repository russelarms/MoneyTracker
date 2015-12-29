package com.makweb.moneytracker.Activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.activeandroid.ActiveAndroid;
import com.makweb.moneytracker.Fragments.BaseFragment;
import com.makweb.moneytracker.Fragments.CategoryFragment_;
import com.makweb.moneytracker.Fragments.ExpensesFragment_;
import com.makweb.moneytracker.Fragments.SettingFragment;
import com.makweb.moneytracker.Fragments.StatisticFragment;
import com.makweb.moneytracker.Models.Categories;
import com.makweb.moneytracker.R;
import com.makweb.moneytracker.database.DB;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private BaseFragment fragment;
    final String TAG = "main activity";

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @ViewById(R.id.navigation_view)
    NavigationView navigationView;

    @ViewById(R.id.coordinator_container)
    CoordinatorLayout coordinatorLayout;

    @InstanceState
    public Integer startActivity;

    @AfterViews
    void ready() {
        setupToolbar();
        setupDrawer();
        setupInitState();
        generateCategory();
    }

    @OptionsItem(android.R.id.home)
    void homeSelected(){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        BaseFragment findingFragment = (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.main_frame);
        if (findingFragment != null && findingFragment instanceof ExpensesFragment_) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
        }

    }

    private void setupInitState(){
        if (startActivity == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new ExpensesFragment_()).commit();
        }
    }

    private void setupDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_expenses:
                        fragment = new ExpensesFragment_();
                        navigationView.getMenu().findItem(R.id.drawer_expenses).setChecked(true);
                        break;
                    case R.id.drawer_categories:
                        fragment = new CategoryFragment_();
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
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24px);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    public  void onFragmentReady(BaseFragment fragment){
        Snackbar.make(fragment.getView(), fragment.getTitle(), Snackbar.LENGTH_SHORT).show();
    }

    void generateCategory() {
        DB.dropTableCategories();

        List categoriesName = new ArrayList();
        categoriesName.add("Одежда");
        categoriesName.add("Книги");
        categoriesName.add("Игры");
        categoriesName.add("Развлечения");
        categoriesName.add("Сигареты");
        categoriesName.add("Прочее");
        ActiveAndroid.beginTransaction();
        try {
            for (int i = 0; i < categoriesName.size() ; i++) {
                Categories item = new Categories();
                item.setName(String.valueOf(categoriesName.get(i)));
                item.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

}
