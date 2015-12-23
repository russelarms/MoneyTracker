package com.makweb.moneytracker.Views;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makweb.moneytracker.Models.Expense;
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

    public void bind(Expense expenses){
        txt_name.setText(expenses.getTitle());
        txt_sum.setText(String.valueOf(expenses.getSum()));
        txt_date.setText(expenses.getDate());
    }
}