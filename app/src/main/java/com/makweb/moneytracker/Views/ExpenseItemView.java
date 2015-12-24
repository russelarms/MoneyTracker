package com.makweb.moneytracker.Views;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makweb.moneytracker.Models.Expenses;
import com.makweb.moneytracker.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;


@EViewGroup(R.layout.item_expenses)
public class ExpenseItemView extends RelativeLayout {

    @ViewById(R.id.txt_name)
    TextView txt_name;

    @ViewById(R.id.txt_sum)
    TextView txt_sum;

    @ViewById(R.id.txt_date)
    TextView txt_date;

    public ExpenseItemView(Context context) {
        super(context);
    }

    public void bind(Expenses expenses){
        txt_name.setText(expenses.getName());
        txt_sum.setText(String.valueOf(expenses.getPrice()));
        txt_date.setText(expenses.getDate());
    }
}