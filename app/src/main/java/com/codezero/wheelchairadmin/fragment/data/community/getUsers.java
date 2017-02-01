package com.codezero.wheelchairadmin.fragment.data.community;

import android.os.AsyncTask;
import android.util.Log;

import com.codezero.wheelchairadmin.fragment.data.UserData;
import com.codezero.wheelchairadmin.fragment.message.MessageData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by GyungSik on 2017-02-01.
 */

public class getUsers extends AsyncTask<Void, Void, ArrayList<UserData>> {
    private final String serverUrl = "http://gayangcodezero.iptime.org:8080/users.php";

    @Override
    protected ArrayList<UserData> doInBackground(Void... params) {
        try {
            ArrayList<UserData> result = new ArrayList<>();
            String jsonText = getText();
            Log.i("users!!!", jsonText);
            JSONArray array = new JSONArray(jsonText);
            for(int i = 0;i<array.length();i++){
                JSONObject jsonObject = array.getJSONObject(i);
                String userName = jsonObject.getString("user_name");
                String companyName = jsonObject.getString("company_name");
                String phone = jsonObject.getString("phone");
                String deviceAddress = jsonObject.getString("device_address");
                String deviceNumber = jsonObject.getString("device_number");
                result.add(new UserData(deviceNumber, companyName, userName, phone, deviceAddress));
            }
            return result;
        }catch(Exception e){
            Log.e("users fail...", e.getMessage());
            return null;
        }
    }

    private String getText() throws IOException {
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
