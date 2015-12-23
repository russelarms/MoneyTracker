package com.makweb.moneytracker.Utils;

import android.app.Application;

import com.bettervectordrawable.VectorDrawableCompat;
import com.makweb.moneytracker.R;

public class VectorDraw extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        VectorDrawableCompat.enableResourceInterceptionFor(getResources(),
                R.drawable.ic_menu_black_24px,
                R.drawable.ic_account_balance_wallet_black_24px,
                R.drawable.ic_settings_black_24px,
                R.drawable.ic_timeline_black_24px,
                R.drawable.ic_view_list_black_24px,
                R.drawable.ic_add_black_24px);
    }
}
