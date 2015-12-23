package com.makweb.moneytracker.Fragments;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.makweb.moneytracker.Activities.AddExpenseActivity_;
import com.makweb.moneytracker.Adapters.ExpenseAdapter;
import com.makweb.moneytracker.Models.Expense;
import com.makweb.moneytracker.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_expenses)
public class ExpensesFragment extends BaseFragment {

    @ViewById(R.id.fab)
    FloatingActionButton floatingActionButton;

    @ViewById(R.id.context_recyclerview)
    RecyclerView expensesRecyclerView;

    @Bean
    ExpenseAdapter expenseAdapter;

    @AfterViews
    void fragmentInit(){
        List<Expense> adapterData = getDataList();
        expenseAdapter.setData(adapterData);

        expensesRecyclerView.setAdapter(expenseAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        expensesRecyclerView.setLayoutManager(gridLayoutManager);
        getActivity().setTitle("Траты");
        setItemDrawer(R.id.drawer_expenses);
    }

    @Click(R.id.fab)
    void fabPress(){
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
