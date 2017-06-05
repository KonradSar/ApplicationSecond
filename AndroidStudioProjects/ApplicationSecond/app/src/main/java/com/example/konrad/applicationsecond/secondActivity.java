package com.example.konrad.applicationsecond;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

import static com.example.konrad.applicationsecond.R.id.button2;

public class secondActivity extends AppCompatActivity {
    final String TAG = "KonradApp";


    @BindView(R.id.button2) Button goToPageButton;
    @BindView(R.id.view) WebView vebView;
    String przekazanyWPorzednimOknieAdres;

    @OnClick(R.id.button2)
        public void open() {

            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(poprawienieAdresuStrony(przekazanyWPorzednimOknieAdres)));
            startActivity(i);
        }


    @OnLongClick(R.id.button2)
    public boolean open2(){
        Log.d(TAG, "onLong");
        Log.d(TAG, "a: " + przekazanyWPorzednimOknieAdres);
        vebView.loadUrl(przekazanyWPorzednimOknieAdres);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);

        Intent i = getIntent();
        przekazanyWPorzednimOknieAdres = i.getStringExtra("dana_kod");

    }

    public String poprawienieAdresuStrony(String adres) {
        if (!adres.contains("http://")) {
            adres = "http://" + adres;
        }
        return adres;
    }
}
