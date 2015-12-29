package com.makweb.moneytracker.Fragments;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.makweb.moneytracker.Adapters.CategoryAdapter;
import com.makweb.moneytracker.Models.Categories;
import com.makweb.moneytracker.R;
import com.makweb.moneytracker.database.DB;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

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
        List<Categories> adapterData = getDataList();
        categoryAdapter.setData(adapterData);
        categoryListView.setAdapter(categoryAdapter);
        getActivity().setTitle("Категории");
        setItemDrawer(R.id.drawer_categories);
    }

    @Click(R.id.fab)
    void fabPress(){
        Snackbar.make(coordinatorLayout, "Категории", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private List<Categories> getDataList() {
        return new Select()
                .from(Categories.class)
                .execute();
    }

    private void loadData() {
        getLoaderManager().restartLoader(0, null, new LoaderManager.LoaderCallbacks<List<Categories>>() {
            @Override
            public Loader<List<Categories>> onCreateLoader(int id, Bundle args) {
                final AsyncTaskLoader<List<Categories>> loader = new AsyncTaskLoader<List<Categories>>(getActivity()) {
                    @Override
                    public List<Categories> loadInBackground() {
                        return DB.getDataListCategories();
                    }
                };

                loader.forceLoad();
                return loader;
            }

            @Override
            public void onLoadFinished(Loader<List<Categories>> loader, List<Categories> data) {
                categoryAdapter.setData(data);
                categoryListView.setAdapter(categoryAdapter);
            }

            @Override
            public void onLoaderReset(Loader<List<Categories>> loader) {

            }
        });
    }
}
