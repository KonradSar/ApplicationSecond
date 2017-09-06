package com.example.konrad.applicationsecond;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Konrad on 25.07.2017.
 */

public class MojAsyncTaskClass extends AsyncTask<String, Void, String>{
    TextView textView;

    public MojAsyncTaskClass(TextView textView){
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("Zaczynamy");
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
        textView.setText("Czesc " + result);
    }
}
