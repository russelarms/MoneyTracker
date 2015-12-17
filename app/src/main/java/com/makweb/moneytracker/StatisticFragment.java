package com.makweb.moneytracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StatisticFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView=inflater.inflate(R.layout.statistic_fragment,container,false);

        getActivity().setTitle("Статистика");
        return mainView;
    }
}
