package com.codezero.wheelchairadmin.fragment.message.comunity;

import android.os.AsyncTask;
import android.util.Log;

import com.codezero.wheelchairadmin.fragment.message.MessageData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by GyungSik on 2017-02-01.
 */

public class getMessage extends AsyncTask<Void, Void, ArrayList<MessageData>> {
    private final String serverUrl = "http://gayangcodezero.iptime.org:8080/message.php";

    @Override
    protected ArrayList<MessageData> doInBackground(Void... params) {
        try {
            ArrayList<MessageData> result = new ArrayList<>();
            String jsonText = getText();
            Log.i("message!!!", jsonText);
            JSONArray array = new JSONArray(jsonText);
            for(int i = 0;i<array.length();i++){
                JSONObject jsonObject = array.getJSONObject(i);
                String idx = jsonObject.getString("idx");
                String userName = jsonObject.getString("user_name");
                String companyName = jsonObject.getString("company_name");
                String phone = jsonObject.getString("phone");
                String message = jsonObject.getString("message");
                result.add(new MessageData(idx, userName, phone, message, companyName));
            }
            return result;
        }catch(Exception e){
            Log.e("Message fail...", e.getMessage());
            return null;
        }
    }

    private String getText() throws IOException{
        String fullString = "";
        URL url = new URL(serverUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            fullString += line;
        }
        reader.close();
        return fullString;
    }
}
