package com.makweb.moneytracker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class ExpenseAdapter extends ArrayAdapter<Expense> {
    List<Expense> expenses;



    public ExpenseAdapter(Context context, List<Expense> expenses) {
        super(context, 0, expenses);
        this.expenses=expenses;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Expense expense=getItem(position);
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.txt_name);
        TextView sum = (TextView) convertView.findViewById(R.id.txt_sum);
        TextView date=(TextView) convertView.findViewById(R.id.txt_date);
        RelativeLayout list_item=(RelativeLayout) convertView.findViewById(R.id.list_item);

        int myColor=getContext().getResources().getColor(R.color.colorAccent);
        float opacity=1- position*1.0f/getCount();
        int myBgColor = adjustAlpha(myColor, opacity);

        list_item.setBackgroundColor(myBgColor);

        //Log.d("ADAPTER", String.valueOf(opacity));

        name.setText(expense.getTitle());
        sum.setText(expense.getSum().toString());
        date.setText(expense.getDate());
        return convertView;
    }

    public int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }
}
