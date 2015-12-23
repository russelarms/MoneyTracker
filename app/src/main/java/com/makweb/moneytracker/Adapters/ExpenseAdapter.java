package com.makweb.moneytracker.Adapters;

import android.content.Context;
import android.view.ViewGroup;

import com.makweb.moneytracker.Models.Expense;
import com.makweb.moneytracker.Views.ExpenseItemView;
import com.makweb.moneytracker.Views.ExpenseItemView_;
import com.makweb.moneytracker.Views.ViewWrapper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class ExpenseAdapter extends RecyclerViewAdapterBase<Expense, ExpenseItemView> {

   // List<Expense> expenses;

    @RootContext
    Context context;

    @Override
    protected ExpenseItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ExpenseItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<ExpenseItemView> viewHolder, int position) {
        ExpenseItemView view = viewHolder.getView();
        Expense expense = items.get(position);

        view.bind(expense);
    }

  /*  public void setData(List<Expense> expenses){
        this.expenses=expenses;
    }*/

    /*public ExpenseAdapter(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expenses, parent, false);
        return new CardViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Expense expense = expenses.get(position);

        holder.txt_name.setText(expense.getTitle());
        holder.txt_sum.setText(String.valueOf(expense.getSum()));
        holder.txt_date.setText(expense.getDate());
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        protected TextView txt_name;
        protected TextView txt_sum;
        protected TextView txt_date;

        public CardViewHolder(View convertView) {
            super(convertView);
            txt_name = (TextView) convertView.findViewById(R.id.txt_name);
            txt_sum = (TextView) convertView.findViewById(R.id.txt_sum);
            txt_date = (TextView) convertView.findViewById(R.id.txt_date);
        }
    }*/
}
