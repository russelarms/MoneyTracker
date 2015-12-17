package com.makweb.moneytracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Context context,  List<Category> categories) {
        super(context, 0, categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Category categories=getItem(position);

        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.category_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.txt_name);
        TextView sum = (TextView) convertView.findViewById(R.id.txt_sum);

        name.setText(categories.getName());
        sum.setText(String.valueOf(categories.getSum()));

        return convertView;
    }
}
