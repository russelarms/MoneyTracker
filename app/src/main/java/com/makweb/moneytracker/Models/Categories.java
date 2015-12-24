package com.makweb.moneytracker.Models;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

@Table(name="categories")
public class Categories extends Model{

    public Categories(){
        super();
    }

    @Column(name = "name")
    private String name;

    public Categories(String name){
        super();
        this.name=name;
    }

    public List<Expenses> expenses(){
        return getMany(Expenses.class, "category");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
