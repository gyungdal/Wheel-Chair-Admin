package com.codezero.wheelchairadmin.fragment.data;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.codezero.wheelchairadmin.R;

import java.util.ArrayList;

/**
 * Created by GyungDal on 2017-01-31.
 */
public class DataListViewAdapter extends BaseAdapter {

    public ArrayList<UserData> userData;
    Activity activity;

    public DataListViewAdapter(Activity activity, ArrayList<UserData> userData) {
        super();
        this.activity = activity;
        this.userData = userData;
    }

    @Override
    public int getCount() {
        return userData.size();
    }

    @Override
    public Object getItem(int position) {
        return userData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView modelNumber;
        TextView companyName;
        TextView userName;
        TextView phoneNumber;
        TextView modelAddress;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_data, null);
            holder = new ViewHolder();
            holder.modelAddress = (TextView) convertView.findViewById(R.id.model_address);
            holder.modelNumber = (TextView) convertView.findViewById(R.id.model_number);
            holder.phoneNumber = (TextView) convertView.findViewById(R.id.phone_number);
            holder.userName = (TextView) convertView.findViewById(R.id.user_name);
            holder.companyName = (TextView) convertView.findViewById(R.id.company_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final UserData item = userData.get(position);
        if(!item.isTitle) {
            holder.modelAddress.setText(item.getModelAddress());
            holder.modelNumber.setText(item.getModelNumber());
            holder.phoneNumber.setText(item.getPhoneNumber());
            holder.userName.setText(item.getUserName());
            holder.companyName.setText(item.getCompanyName());
        }
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(activity, item.getModelAddress(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return convertView;
    }
}