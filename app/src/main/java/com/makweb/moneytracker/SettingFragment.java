package com.makweb.moneytracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SettingFragment extends BaseFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.settings_fragment, container, false);

        getActivity().setTitle("Настройки");
        setItemDrawer(R.id.drawer_settings);
        return mainView;
    }

}
