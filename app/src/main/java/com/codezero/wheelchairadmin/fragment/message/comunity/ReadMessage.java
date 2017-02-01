package com.codezero.wheelchairadmin.fragment.message.comunity;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by GyungSik on 2017-02-01.
 */

public class ReadMessage extends AsyncTask<Void, Void, Boolean> {
    private final String serverUrl = "http://gayangcodezero.iptime.org:8080/readMessage.php?idx=";
    private String idx;
    public ReadMessage(String idx){
        this.idx = idx;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            String jsonText = getText();
            Log.i("read message result", jsonText);
            if(jsonText.isEmpty())
                return Boolean.FALSE;
            JSONObject jsonObject = new JSONObject(jsonText);
            if(jsonObject.getString("result").equals("ok"))
                return Boolean.TRUE;
        }catch(Exception e){
            Log.e("Read Message", e.getMessage());
        }
        return Boolean.FALSE;
    }

    private String getText() throws IOException {
        String fullString = "";
        URL url = new URL(serverUrl + idx);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            fullString += line;
        }
        reader.close();
        return fullString;
    }
}
