package com.makweb.moneytracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SettingFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView=inflater.inflate(R.layout.settings_fragment,container,false);

        getActivity().setTitle("Настройки");
        return mainView;
    }

}
