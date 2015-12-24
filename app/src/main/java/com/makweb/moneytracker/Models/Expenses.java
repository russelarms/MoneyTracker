package com.makweb.moneytracker.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Table(name = "Expenses")
public class Expenses extends Model {
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", new Locale("ru"));

    @Column(name = "price")
    private Double price;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "category")
    private Categories category;

    public Expenses() {
        super();
    }

    public Expenses(Double price, String name, String date, Categories category) {
        this.price = price;
        this.name = name;
        if (date == null) {
            this.date = dateFormat.format(Calendar.getInstance().getTime());
        } else {
            this.date = date;
        }
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public Categories getCategory() {
        return category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        if (date == null) {
            this.date = dateFormat.format(Calendar.getInstance().getTime());
        } else {
            this.date = date;
        }
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
