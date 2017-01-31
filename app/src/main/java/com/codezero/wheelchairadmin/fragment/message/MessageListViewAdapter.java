package com.codezero.wheelchairadmin.fragment.message;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.codezero.wheelchairadmin.R;

import java.util.ArrayList;

/**
 * Created by GyungDal on 2017-01-31.
 */
public class MessageListViewAdapter extends BaseAdapter {

    public ArrayList<MessageData> data;
    Activity activity;

    public MessageListViewAdapter(Activity activity, ArrayList<MessageData> data) {
        super();
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView company;
        TextView name;
        ImageButton checkMsgButton;
        ImageButton callButton;
        ImageButton msgButton;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_msg, null);
            holder = new ViewHolder();
            holder.company = (TextView)convertView.findViewById(R.id.company);
            holder.name = (TextView)convertView.findViewById(R.id.name);
            holder.callButton = (ImageButton) convertView.findViewById(R.id.call);
            holder.checkMsgButton = (ImageButton) convertView.findViewById(R.id.check_msg);
            holder.msgButton = (ImageButton) convertView.findViewById(R.id.msg);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final MessageData item = data.get(position);
        holder.company.setText(item.getCompany());
        holder.name.setText(item.getName());
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + item.getNumber()));
                activity.startActivity(intent);
            }
        });
        holder.msgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("address", item.getNumber());
                intent.putExtra("sms_body", "");
                intent.setType("vnd.android-dir/mms-sms");
                activity.startActivity(intent);
            }
        });
        holder.checkMsgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(item.getMsg());
                builder.setTitle("(" + item.getCompany() + ") " + item.getName());
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });


        return convertView;
    }
}