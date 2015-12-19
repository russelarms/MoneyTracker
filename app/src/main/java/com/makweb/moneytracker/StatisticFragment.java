package com.makweb.moneytracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StatisticFragment extends BaseFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView=inflater.inflate(R.layout.statistic_fragment, container, false);
        getActivity().setTitle("Статистика");
        setItemDrawer(R.id.drawer_statistics);
        return mainView;
    }
}
