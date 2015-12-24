package com.makweb.moneytracker.Activities;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.makweb.moneytracker.Fragments.DatePickerFragment;
import com.makweb.moneytracker.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@EActivity(R.layout.activity_add_expenses)

public class AddExpenseActivity extends AppCompatActivity {
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", new Locale("ru"));

    @ViewById
    Toolbar toolbar;

    @ViewById(R.id.ted_date)
    TextView txtDate;

    @OptionsItem(R.id.home)
    void back() {
        onBackPressed();
        finish();
    }

    @AfterViews
    void ready() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle("Добавить трату");
        }
            String now=dateFormat.format(Calendar.getInstance().getTime());
            txtDate.setText(now);


    }

    @Click(R.id.ted_date)
    void datePicker(){
        DialogFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void setDateFromDatePicker(String date) {
        txtDate.setText(date);
    }


}
