package com.makweb.moneytracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ExpensesFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ExpenseAdapter expenseAdapter;
        View mainView=inflater.inflate(R.layout.expenses_fragment,container,false);
        ListView expensesListView = (ListView) mainView.findViewById(R.id.list_view);
        List<Expense> adapterData = getDataList();
        expenseAdapter=new ExpenseAdapter(getActivity(), adapterData);
        expensesListView.setAdapter(expenseAdapter);
        getActivity().setTitle("Траты");
        return mainView;
    }

    private List<Expense> getDataList(){
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("Phone","1000"));
        data.add(new Expense("Clothes","2000"));
        data.add(new Expense("Gifts","500"));
        data.add(new Expense("Holidays","5000"));
        return data;
    }
}
