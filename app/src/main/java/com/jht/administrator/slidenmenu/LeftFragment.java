package com.jht.administrator.slidenmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/10/20.
 */
public class LeftFragment extends Fragment{

    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.slide_method_left,container,false);
        String []res = {"java","php","c++","oc","c#"};
        lv = (ListView)view.findViewById(R.id.method_lv);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,res);
        lv.setAdapter(adapter);
        return view;
    }
}
