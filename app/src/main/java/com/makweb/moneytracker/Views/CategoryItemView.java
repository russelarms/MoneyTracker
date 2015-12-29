package com.makweb.moneytracker.Views;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makweb.moneytracker.Models.Categories;
import com.makweb.moneytracker.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.item_category)
public class CategoryItemView extends RelativeLayout{

    @ViewById(R.id.txt_name)
    TextView txt_name;

    @ViewById(R.id.txt_sum)
    TextView txt_sum;

    public CategoryItemView(Context context) {
        super(context);
    }

    public void bind(Categories categories){
        txt_name.setText(categories.getName());
        //txt_sum.setText(String.valueOf(categories.getSum()));
    }
}
