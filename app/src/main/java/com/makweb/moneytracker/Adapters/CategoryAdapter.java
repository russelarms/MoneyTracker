package com.makweb.moneytracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.makweb.moneytracker.Models.Category;
import com.makweb.moneytracker.R;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Context context, List<Category> categories) {
        super(context, 0, categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Category categories = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_category, parent, false);
        }

        TextView txt_name = (TextView) convertView.findViewById(R.id.txt_name);
        TextView txt_sum = (TextView) convertView.findViewById(R.id.txt_sum);

        txt_name.setText(categories.getName());
        txt_sum.setText(String.valueOf(categories.getSum()));

        return convertView;
    }
}
