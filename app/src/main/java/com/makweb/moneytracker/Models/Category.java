package com.makweb.moneytracker.Models;

public class Category {

    private String name;
    private int sum;

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Category(int sum, String name) {
        this.sum = sum;
        this.name = name;
    }

    public Category() {
    }


}
