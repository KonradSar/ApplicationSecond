package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Calculator extends AppCompatActivity {

    final String TAG = "KonradApp";
    @BindView(R.id.editText7) EditText firstVariable;
    @BindView(R.id.editText8) EditText secondVariable;
    @BindView(R.id.editText9) EditText thirdVariable;
    @BindView(R.id.imageButton) ImageButton fuckingImage;
    @BindView(R.id.textView) TextView wynik2;


    @OnClick(R.id.imageButton)
    public void showResult(){
        String first = firstVariable.getText().toString();
        String second = secondVariable.getText().toString();
        String third = thirdVariable.getText().toString();
        double przeliczonaFirst = Double.parseDouble(first);
        double przeliczonaSecond = Double.parseDouble(second);
        double przeliczonaThird = Double.parseDouble(third);

        double krok1 = Math.pow(przeliczonaFirst, 2);
        double krok2 = Math.pow(przeliczonaSecond, 2);
        double krok3 = Math.pow(przeliczonaThird, 2);

        double sum = krok1 + krok2;
        double pierwiastek = Math.sqrt(sum);
        double wynik = pierwiastek / przeliczonaThird;

        wynik2.setText(String.valueOf(wynik));






    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ButterKnife.bind(this);
    }
}
