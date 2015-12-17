package com.makweb.moneytracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CategoryAdapter categoryAdapter;
        View mainView=inflater.inflate(R.layout.category_fragment,container,false);
        ListView expensesListView = (ListView) mainView.findViewById(R.id.list_view);
        List<Category> adapterData = getDataList();
        categoryAdapter=new CategoryAdapter(getActivity(), adapterData);
        expensesListView.setAdapter(categoryAdapter);
        getActivity().setTitle("Категории");
        return mainView;
    }

    private List<Category> getDataList(){
        List<Category> data = new ArrayList<>();
        data.add(new Category(1000,"Книги"));
        data.add(new Category(2000, "Одежда"));
        data.add(new Category(2000, "Еда"));
        return data;
    }


}
