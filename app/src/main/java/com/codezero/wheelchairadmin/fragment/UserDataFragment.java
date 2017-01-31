package com.codezero.wheelchairadmin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codezero.wheelchairadmin.R;
import com.codezero.wheelchairadmin.fragment.data.UserData;
import com.codezero.wheelchairadmin.fragment.data.DataListViewAdapter;

import java.util.ArrayList;

/**
 * Created by GyungDal on 2017-01-31.
 */

public class UserDataFragment extends Fragment {
    private ListView listview;
    private DataListViewAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_data, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ArrayList<UserData> userData = new ArrayList<UserData>();
        super.onViewCreated(view, savedInstanceState);
        userData.add(new UserData());
        userData.add(new UserData("000000001", "codezero", "GG", "01089537414", "20:20:20:20:20:20"));
        adapter = new DataListViewAdapter(getActivity(), userData);
        listview = (ListView)view.findViewById(R.id.list);
        listview.setAdapter(adapter);
    }
}