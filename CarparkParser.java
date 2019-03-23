package com.example.playgroundproj;

import android.os.Message;
import android.util.JsonReader;
import android.util.Log;

import org.json.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarparkParser {

    /*
    TO IMPLEMENT:
        private JSONArray carparks;

        public CarparkParser(String from) {
            // parses the JSON string so that "carpark_data" array is extracted
        }

        public JSONObject getCarpark(String cpNumber) {}
        public int getAvailability(JSONObject carpark) {}
        and so on...s
     */



    private String jStr;

    public void from(String s) {
        jStr = s;
    }

    // just a demo method to try parsing json
    public void printCarparkNumbers() throws IOException {
        try {
            JSONObject object = new JSONObject(jStr)
                    .getJSONArray("items").getJSONObject(0);
            JSONArray carparkData = object.getJSONArray("carpark_data");

            ArrayList<String> numbers = new ArrayList<>();
            for (int i=0; i<carparkData.length(); i++) {
                JSONObject carpark = carparkData.getJSONObject(i);
                String cpNumber = carpark.getString("carpark_number");
                numbers.add(cpNumber);
                //Log.e("MainActivity", cpNumber);
                if (numbers.contains("S40L")) {
                    Log.e("MainActivity", "S40L FOUND!!!");
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
