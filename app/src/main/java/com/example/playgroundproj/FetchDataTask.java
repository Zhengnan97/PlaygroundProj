package com.example.playgroundproj;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

public class FetchDataTask extends AsyncTask<String, Void, String> {

    private DataFetcher fetcher;

    public FetchDataTask() {
        fetcher = new DataFetcher();
    }

    @Override
    protected String doInBackground(String... url) {
        // fetch govt data and print in log

        fetcher.setAsUri(url[0]);
        try {
            String ans = fetcher.testFetchString(500);
            Log.e("MainActivity", ans);
            return ans;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
