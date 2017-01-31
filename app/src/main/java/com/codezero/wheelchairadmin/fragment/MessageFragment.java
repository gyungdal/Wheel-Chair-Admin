package com.codezero.wheelchairadmin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codezero.wheelchairadmin.R;
import com.codezero.wheelchairadmin.fragment.message.MessageData;
import com.codezero.wheelchairadmin.fragment.message.MessageListViewAdapter;

import java.util.ArrayList;

/**
 * Created by GyungDal on 2017-01-31.
 */

public class MessageFragment extends Fragment {
    private ListView listview;
    private MessageListViewAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_data, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ArrayList<MessageData> data = new ArrayList<>();
        super.onViewCreated(view, savedInstanceState);
        data.add(new MessageData("GG", "01089537414", "I want go home", "codezero"));
        adapter = new MessageListViewAdapter(getActivity(), data);
        listview = (ListView)view.findViewById(R.id.list);
        listview.setAdapter(adapter);
    }
}