package com.example.konrad.applicationsecond;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    final String TAG = "KonradApp";


    @BindView(R.id.editText) EditText mailAddressField;

    @BindView(R.id.GoToWebButtonId) Button GoToWebButton;
    String zmiennaPomocniczaText;


    @OnClick(R.id.GoToWebButtonId)
    public void openWebPage(){

        zmiennaPomocniczaText = mailAddressField.getText().toString();
        Log.d(TAG, zmiennaPomocniczaText);
        Intent i = new Intent(MainActivity.this, secondActivity.class);
        //pierwszy klucz druga wartosc
        i.putExtra("dana_kod", zmiennaPomocniczaText);
        startActivity(i);





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity: onCreate");
        ButterKnife.bind(this);
        mailAddressField.setHint("Enter http address");








    }
    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }








}




