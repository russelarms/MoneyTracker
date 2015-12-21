package com.makweb.moneytracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Expense {
    private String title;
    private Integer sum;
    private String date;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", new Locale("ru"));

    public Expense() {
    }

    public Expense(String title, String sum) {
        this.title = title;
        this.sum = Integer.parseInt(sum);
        this.date = dateFormat.format(Calendar.getInstance().getTime());
    }

    public String getTitle() {
        return title;
    }

    public Integer getSum() {
        return sum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSum(String sum) {
        this.sum = Integer.parseInt(sum);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = dateFormat.format(Calendar.getInstance().getTime());
    }
}
