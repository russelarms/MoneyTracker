package com.makweb.moneytracker.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.makweb.moneytracker.Models.Category;
import com.makweb.moneytracker.Views.CategoryItemView;
import com.makweb.moneytracker.Views.CategoryItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class CategoryAdapter extends BaseAdapter {

    List<Category> categories;

    @RootContext
    Context context;

    public void setData(List<Category> categories){
        this.categories=categories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryItemView categoriesItemView;

        if (convertView == null) {
            categoriesItemView= CategoryItemView_.build(context);
        }else{
            categoriesItemView = (CategoryItemView) convertView;
        }

        categoriesItemView.bind(getItem(position));

        return categoriesItemView;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Category getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
