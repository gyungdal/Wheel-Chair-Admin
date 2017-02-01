package com.codezero.wheelchairadmin.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.AsyncLayoutInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.codezero.wheelchairadmin.R;
import com.codezero.wheelchairadmin.fragment.data.UserData;
import com.codezero.wheelchairadmin.fragment.data.DataListViewAdapter;
import com.codezero.wheelchairadmin.fragment.data.community.getUsers;

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
        try{
            ArrayList<UserData> temp = new getUsers().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR).get();
            if(temp != null)
                userData.addAll(temp);
            else
                Toast.makeText(getContext(), "get fail...", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Log.e("USERS", e.getMessage());
        }
        adapter = new DataListViewAdapter(getActivity(), userData);
        listview = (ListView)view.findViewById(R.id.list);
        listview.setAdapter(adapter);
    }
}