package com.example.konrad.applicationsecond;

import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Konrad on 27.07.2017.
 */

public class MojAsyncTaskClass2 extends AsyncTask<String, Void, String> {
    ListView listView;

    public MojAsyncTaskClass2(ListView textView){
        this.listView = listView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... params) {
        String imie1 = params[0];
        String imie2 = params[1];

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        String imie = imie1+ " " + imie2;

        return imie;
    }

    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);


    }
}

