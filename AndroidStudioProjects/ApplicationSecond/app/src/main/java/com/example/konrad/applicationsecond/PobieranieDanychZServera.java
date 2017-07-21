package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PobieranieDanychZServera extends AppCompatActivity {
    final String TAG = "KonradApp";
    @BindView(R.id.button11) Button firstBtn;
    @BindView(R.id.textView99) EditText editT;

    @OnClick(R.id.button11)
    public void check(){
        if (editT != null){
            Editable data = editT.getText();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pobieranie_danych_zservera);
        ButterKnife.bind(this);




        }
    }
