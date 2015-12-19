package com.makweb.moneytracker;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment{

    public void setItemDrawer(int itemLink) {
        NavigationView navigationView= (NavigationView) getActivity().findViewById(R.id.navigation_view);
        navigationView.getMenu().findItem(itemLink).setChecked(true);
    }

}
