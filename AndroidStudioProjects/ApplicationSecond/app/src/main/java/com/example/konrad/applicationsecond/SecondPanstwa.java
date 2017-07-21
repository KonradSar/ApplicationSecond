package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondPanstwa extends AppCompatActivity {

    final String TAG = "KonradApp";
    @BindView(R.id.textView) TextView mojeText;
    public static Spanned fromHtml(String html){
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html,Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_panstwa);
        ButterKnife.bind(this);

        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(myToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String[] panstwa = {"Polska", "Francja", "Włochy", "Szkocja", "Szwecja", "Rosja", "Czechy", "Usa", "Australia", "Belgia", "Irlandia", "Portugalia", "Hiszpania", "Anglia", "Brazylia", "Argentyna"};
        ArrayList<String> panstwaL = new ArrayList<>();
        panstwaL.addAll(Arrays.asList(panstwa));

        String text = "";
        for (String item : panstwaL) {
            text = text + item + "<br/>";
        }


        mojeText.setText(fromHtml(text));
    }
}

