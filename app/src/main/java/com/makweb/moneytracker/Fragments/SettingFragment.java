package com.makweb.moneytracker.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makweb.moneytracker.R;


public class SettingFragment extends BaseFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_settings, container, false);

        getActivity().setTitle("Настройки");
        setItemDrawer(R.id.drawer_settings);
        return mainView;
    }

}
