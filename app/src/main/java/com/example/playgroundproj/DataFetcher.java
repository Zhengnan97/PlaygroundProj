package com.example.playgroundproj;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataFetcher {
    private URL uri;
    private InputStream inputStream;

    private String convertInputToString(InputStream stream, int len) throws
            IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        char[] buffer = new char[len];
        reader.read(buffer);
        reader.close();
        return new String(buffer);
    }

    public void setAsUri(String from) {
        try {
        uri = new URL(from);
        } catch (Exception e) {}

    }

    public String testFetchString(int fetchLen) throws IOException {
        assert uri != null;

        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();

        connection.setReadTimeout(10000);
        connection.setConnectTimeout(15000);
        connection.connect();
        int response = connection.getResponseCode();
        Log.d("MainActivity", "Response: " + response);

        inputStream = connection.getInputStream();
        connection.disconnect();
        return convertInputToString(inputStream, fetchLen);
    }
}
