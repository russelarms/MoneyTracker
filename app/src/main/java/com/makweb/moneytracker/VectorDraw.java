package com.makweb.moneytracker;

import android.app.Application;

import com.bettervectordrawable.VectorDrawableCompat;

public class VectorDraw extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        VectorDrawableCompat.enableResourceInterceptionFor(getResources(),
                R.drawable.ic_menu_black_24px);
    }
}
