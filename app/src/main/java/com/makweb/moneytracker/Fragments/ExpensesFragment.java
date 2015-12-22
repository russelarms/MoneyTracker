package com.makweb.moneytracker.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makweb.moneytracker.Activities.AddExpenseActivity_;
import com.makweb.moneytracker.Adapters.ExpenseAdapter;
import com.makweb.moneytracker.Models.Expense;
import com.makweb.moneytracker.R;

import java.util.ArrayList;
import java.util.List;

public class ExpensesFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ExpenseAdapter expenseAdapter;
        final View mainView = inflater.inflate(R.layout.fragment_expenses, container, false);
        RecyclerView expensesRecyclerView = (RecyclerView) mainView.findViewById(R.id.context_recyclerview);
        List<Expense> adapterData = getDataList();
        expenseAdapter = new ExpenseAdapter(adapterData);
        expensesRecyclerView.setAdapter(expenseAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        expensesRecyclerView.setLayoutManager(gridLayoutManager);

        getActivity().setTitle("Траты");
        setItemDrawer(R.id.drawer_expenses);

        FloatingActionButton floatingActionButton = (FloatingActionButton) mainView.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddExpense(view);
            }
        });

        return mainView;
    }

    public void goToAddExpense(View view){
        Intent intent=new Intent(getActivity(), AddExpenseActivity_.class);
        intent.putExtra("key","value");
        startActivity(intent);
    }

    private List<Expense> getDataList() {
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("Phone", "1000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Phone", "1000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Phone", "1000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        data.add(new Expense("Clothes", "2000"));
        data.add(new Expense("Gifts", "500"));
        data.add(new Expense("Holidays", "5000"));
        return data;
    }
}
