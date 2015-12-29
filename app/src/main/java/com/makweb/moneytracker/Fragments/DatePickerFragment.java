package com.makweb.moneytracker.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import com.makweb.moneytracker.Activities.AddExpenseActivity;

import java.util.Calendar;

//@EFragment(R.layout.date_picker_fragment)
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String chooseDate = String.valueOf(day) + '-' + String.valueOf(month) + '-' + String.valueOf(year);

        ((AddExpenseActivity) getActivity()).setDateFromDatePicker(chooseDate);
    }
}
