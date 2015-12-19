package com.makweb.moneytracker;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ExpensesFragment extends BaseFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ExpenseAdapter expenseAdapter;
        final View mainView=inflater.inflate(R.layout.expenses_fragment,container,false);
        RecyclerView expensesRecyclerView = (RecyclerView) mainView.findViewById(R.id.context_recyclerview);
        List<Expense> adapterData = getDataList();
        expenseAdapter=new ExpenseAdapter(adapterData);
        expensesRecyclerView.setAdapter(expenseAdapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        expensesRecyclerView.setLayoutManager(gridLayoutManager);

        getActivity().setTitle("Траты");
        setItemDrawer(R.id.drawer_expenses);
        return mainView;
    }

    private List<Expense> getDataList(){
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("Phone","1000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Phone","1000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Phone","1000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        return data;
    }
}
