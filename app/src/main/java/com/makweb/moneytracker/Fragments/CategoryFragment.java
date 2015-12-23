package com.makweb.moneytracker.Fragments;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.widget.ListView;

import com.makweb.moneytracker.Adapters.CategoryAdapter;
import com.makweb.moneytracker.Models.Category;
import com.makweb.moneytracker.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_category)
public class CategoryFragment extends BaseFragment {

    @ViewById(R.id.coordinator_fragment)
    CoordinatorLayout coordinatorLayout;

    @ViewById(R.id.list_view)
    ListView categoryListView;

    @ViewById(R.id.fab)
    FloatingActionButton floatingActionButton;

    @Bean
    CategoryAdapter categoryAdapter;

    @AfterViews
    void fragmentInit(){
        List<Category> adapterData = getDataList();
        categoryAdapter.setData(adapterData);
        categoryListView.setAdapter(categoryAdapter);
        getActivity().setTitle("Категории");
        setItemDrawer(R.id.drawer_categories);
    }

    @Click(R.id.fab)
    void fabPress(){
        Snackbar.make(coordinatorLayout, "Категории", Snackbar.LENGTH_SHORT).show();
    }

    private List<Category> getDataList() {
        List<Category> data = new ArrayList<>();
        data.add(new Category(1000, "Книги"));
        data.add(new Category(2000, "Одежда"));
        data.add(new Category(2000, "Еда"));
        return data;
    }
}
