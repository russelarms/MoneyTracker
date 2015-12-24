package com.makweb.moneytracker.Adapters;

import android.content.Context;
import android.view.ViewGroup;

import com.makweb.moneytracker.Models.Expenses;
import com.makweb.moneytracker.Views.ExpenseItemView;
import com.makweb.moneytracker.Views.ExpenseItemView_;
import com.makweb.moneytracker.Views.ViewWrapper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class ExpenseAdapter extends RecyclerViewAdapterBase<Expenses, ExpenseItemView> {

    @RootContext
    Context context;

    @Override
    protected ExpenseItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ExpenseItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<ExpenseItemView> viewHolder, int position) {
        ExpenseItemView view = viewHolder.getView();
        Expenses expenses = items.get(position);

        view.bind(expenses);
    }
}
