package com.makweb.moneytracker.Fragments;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.makweb.moneytracker.Models.Category;
import com.makweb.moneytracker.Adapters.CategoryAdapter;
import com.makweb.moneytracker.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends BaseFragment {

    private CoordinatorLayout coordinatorLayout;
    private FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CategoryAdapter categoryAdapter;
        View mainView = inflater.inflate(R.layout.fragment_category, container, false);
        ListView expensesListView = (ListView) mainView.findViewById(R.id.list_view);
        List<Category> adapterData = getDataList();
        categoryAdapter = new CategoryAdapter(getActivity(), adapterData);
        expensesListView.setAdapter(categoryAdapter);
        getActivity().setTitle("Категории");
        setItemDrawer(R.id.drawer_categories);
        coordinatorLayout = (CoordinatorLayout) mainView.findViewById(R.id.coordinator_fragment);
        floatingActionButton = (FloatingActionButton) mainView.findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout, "Категории", Snackbar.LENGTH_SHORT).show();
            }
        });

        return mainView;
    }

    private List<Category> getDataList() {
        List<Category> data = new ArrayList<>();
        data.add(new Category(1000, "Книги"));
        data.add(new Category(2000, "Одежда"));
        data.add(new Category(2000, "Еда"));
        return data;
    }


}
