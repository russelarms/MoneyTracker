package com.makweb.moneytracker.Fragments;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.View;

import com.makweb.moneytracker.Activities.MainActivity;
import com.makweb.moneytracker.R;

public class BaseFragment extends Fragment {

    public void setItemDrawer(int itemLink) {
        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        navigationView.getMenu().findItem(itemLink).setChecked(true);
    }

    public String getTitle(){
        return this.getClass().getSimpleName();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).onFragmentReady(this);
    }
}
