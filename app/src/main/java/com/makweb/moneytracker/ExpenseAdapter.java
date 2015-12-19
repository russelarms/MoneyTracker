package com.makweb.moneytracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.CardViewHolder> {
    List<Expense> expenses;

    public ExpenseAdapter(List<Expense> expenses){
        this.expenses=expenses;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CardViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Expense expense=expenses.get(position);

        holder.txt_name.setText(expense.getTitle());
       holder.txt_sum.setText(String.valueOf(expense.getSum()));
        holder.txt_date.setText(expense.getDate());
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        protected TextView txt_name;
        protected TextView txt_sum;
        protected TextView txt_date;

        public CardViewHolder(View convertView) {
            super(convertView);
            txt_name=(TextView) convertView.findViewById(R.id.txt_name);
            txt_sum=(TextView) convertView.findViewById(R.id.txt_sum);
            txt_date=(TextView) convertView.findViewById(R.id.txt_date);
        }
    }
}
