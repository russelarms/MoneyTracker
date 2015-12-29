package com.makweb.moneytracker.Activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.makweb.moneytracker.Adapters.CategoryAdapter;
import com.makweb.moneytracker.Fragments.DatePickerFragment;
import com.makweb.moneytracker.Models.Categories;
import com.makweb.moneytracker.Models.Expenses;
import com.makweb.moneytracker.R;
import com.makweb.moneytracker.database.DB;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@EActivity(R.layout.activity_add_expenses)

public class AddExpenseActivity extends AppCompatActivity {
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", new Locale("ru"));
    private List<Categories> data;
    private List<String> dataStr = new ArrayList<>();
//    private List<TextView>

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.ted_date)
    TextView tedDate;

    @ViewById(R.id.ted_name)
    TextView tedName;

    @ViewById(R.id.ted_price)
    TextView tedPrice;

    @ViewById(R.id.spin_category)
    Spinner spinnerCategory;

    @ViewById(R.id.coordinator_container)
    CoordinatorLayout coordinatorContainer;

    @Bean
    CategoryAdapter categoryAdapter;

    @OptionsItem(android.R.id.home)
    void back() {
        if (isFieldNotNull(new TextView[]{tedDate, tedName, tedPrice})){
            insertData();
            onBackPressed();
            finish();
        }
        else {
            Snackbar.make(coordinatorContainer, "Заполните все поля", Snackbar.LENGTH_SHORT).show();
        }
    }

    @AfterViews
    void ready() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle("Добавить трату");
        }
        String now=dateFormat.format(Calendar.getInstance().getTime());
        tedDate.setText(now);
        setupSpinner();
    }

    @Click(R.id.ted_date)
    void datePicker(){
        DialogFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void setDateFromDatePicker(String date) {
        tedDate.setText(date);
    }

    private void insertData(){
        Expenses expenses = new Expenses();
        expenses.setPrice(Integer.parseInt(String.valueOf(tedPrice.getText())));
        expenses.setName(String.valueOf(tedName.getText()));
        String item = spinnerCategory.getSelectedItem().toString();
        Categories category = DB.getCategoryByName(item);
        expenses.setCategory(category);
        expenses.setDate(String.valueOf(tedDate.getText()));
        expenses.save();
    }

    private void setupSpinner(){
        Categories categories = new Categories();
        data = DB.getDataListCategories();
        for (Categories c : data) {
            dataStr.add(c.getName());
        }
        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataStr);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(spinAdapter);
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(view, adapterView.getSelectedItem().toString(), Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private boolean isFieldNotNull(TextView[] field){
        boolean flag = true;

        for (TextView f : field) {
            CharSequence a = f.getText();
            if (f.getText().length()==0){
                flag=false;
                break;
            }
        }

        return flag;
    }



}
