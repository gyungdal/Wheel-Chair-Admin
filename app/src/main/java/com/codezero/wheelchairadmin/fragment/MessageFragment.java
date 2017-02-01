package com.codezero.wheelchairadmin.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.codezero.wheelchairadmin.R;
import com.codezero.wheelchairadmin.fragment.message.MessageData;
import com.codezero.wheelchairadmin.fragment.message.MessageListViewAdapter;
import com.codezero.wheelchairadmin.fragment.message.comunity.getMessage;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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
        super.onViewCreated(view, savedInstanceState);
        ArrayList<MessageData> data = new ArrayList<>();
        try {
            ArrayList<MessageData> items = new getMessage().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR).get();
            if(items != null)
                data.addAll(new getMessage().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR).get());
            else
                Toast.makeText(getContext(), "Not found message", Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        adapter = new MessageListViewAdapter(getActivity(), data);
        listview = (ListView)view.findViewById(R.id.list);
        listview.setAdapter(adapter);
    }
}