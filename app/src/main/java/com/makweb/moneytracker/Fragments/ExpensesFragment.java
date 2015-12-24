package com.makweb.moneytracker.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import com.makweb.moneytracker.Activities.AddExpenseActivity_;
import com.makweb.moneytracker.Adapters.ExpenseAdapter;
import com.makweb.moneytracker.Models.Categories;
import com.makweb.moneytracker.Models.Expenses;
import com.makweb.moneytracker.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

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
    void fragmentInit() {
        Expenses expenses = new Expenses();
        expenses.setPrice(12.0);
        expenses.setName("cinema");
        Categories categoriesFun=new Categories("Fun");
        categoriesFun.save();
        expenses.setCategory(categoriesFun);
        expenses.setDate("12-12-12");
        expenses.save();

        //Expenses expenses1=getExpenses();
        //Log.e("MODEL", String.valueOf(expenses1));
        //expenseAdapter.setData(adapterData);

        //expensesRecyclerView.setAdapter(expenseAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        expensesRecyclerView.setLayoutManager(gridLayoutManager);
        getActivity().setTitle("Траты");
        setItemDrawer(R.id.drawer_expenses);
    }

    @Click(R.id.fab)
    void fabPress() {
        Intent intent = new Intent(getActivity(), AddExpenseActivity_.class);
        intent.putExtra("key", "value");
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    void generateData() {
        ActiveAndroid.beginTransaction();
        try {
            for (int i = 0; i < 100; i++) {
                Expenses item = new Expenses();
                item.setPrice(12.0 + i * 0.1);
                item.setName("Example " + i);
                Categories categoryItem = new Categories();
                categoryItem.setName("что то");
                item.setDate("11-11-11");
                item.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }

    private List<Expenses> getDataList() {
        return new Select()
                .from(Expenses.class)
                .execute();
    }

    private void loadData() {
        getLoaderManager().restartLoader(0, null, new LoaderManager.LoaderCallbacks<List<Expenses>>() {
            @Override
            public Loader<List<Expenses>> onCreateLoader(int id, Bundle args) {
                final AsyncTaskLoader<List<Expenses>> loader = new AsyncTaskLoader<List<Expenses>>(getActivity()) {
                    @Override
                    public List<Expenses> loadInBackground() {
                        return getDataList();
                    }
                };

                loader.forceLoad();
                return loader;
            }

            @Override
            public void onLoadFinished(Loader<List<Expenses>> loader, List<Expenses> data) {
                expenseAdapter.setData(data);
                expensesRecyclerView.setAdapter(expenseAdapter);
            }

            @Override
            public void onLoaderReset(Loader<List<Expenses>> loader) {

            }
        });
    }
}
