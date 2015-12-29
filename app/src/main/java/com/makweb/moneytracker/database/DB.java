package com.makweb.moneytracker.database;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.makweb.moneytracker.Models.Categories;
import com.makweb.moneytracker.Models.Expenses;

import java.util.List;

 public class DB {
     public static final DB INSTANCE = new DB();

     public static List<Categories> getDataListCategories() {
        return new Select()
                .from(Categories.class)
                .execute();
    }

     public static List<Expenses> getDataListExpenses() {
         return new Select()
                 .from(Expenses.class)
                 .execute();
     }

     public static void dropTableCategories() {
         new Delete()
                 .from(Categories.class)
                 .where("Id >= ?", 1)
                 .execute();
     }
}
