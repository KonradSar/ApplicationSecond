package com.example.konrad.aplikacjadotestow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        calculator = new Calculator();

    }
    @BindView(R.id.pierwszaLiczba) EditText liczbaPierwsza;
    @BindView(R.id.drugaLiczba) EditText drugaLiczba;
    @BindView(R.id.display) TextView wynikDisplay;

    @OnClick(R.id.dodawanie)
    public void show(){
        String wynik1 = liczbaPierwsza.getText().toString();
        int przeliczonaWartoscLiczbaPierwsza = Integer.parseInt(wynik1);
        String wynik2 = liczbaPierwsza.getText().toString();
        int przeliczonaWartoscLiczbaDruga = Integer.parseInt(wynik2);
        calculator.dodawaj(przeliczonaWartoscLiczbaPierwsza, przeliczonaWartoscLiczbaDruga);
        wynikDisplay.setText(String.valueOf(calculator));


    }
    @OnClick(R.id.odejmowanie)
    public void show2(){
        String wynik1 = liczbaPierwsza.getText().toString();
        int przeliczonaWartoscLiczbaPierwsza = Integer.parseInt(wynik1);
        String wynik2 = liczbaPierwsza.getText().toString();
        int przeliczonaWartoscLiczbaDruga = Integer.parseInt(wynik2);
        calculator.odejmij(przeliczonaWartoscLiczbaPierwsza, przeliczonaWartoscLiczbaDruga);
        wynikDisplay.setText(String.valueOf(calculator));

    }
    @OnClick(R.id.mnozenie)
    public void show3(){
        String wynik1 = liczbaPierwsza.getText().toString();
        int przeliczonaWartoscLiczbaPierwsza = Integer.parseInt(wynik1);
        String wynik2 = liczbaPierwsza.getText().toString();
        int przeliczonaWartoscLiczbaDruga = Integer.parseInt(wynik2);
        calculator.pomnoz(przeliczonaWartoscLiczbaPierwsza, przeliczonaWartoscLiczbaDruga);
        wynikDisplay.setText(String.valueOf(calculator));

    }
    @OnClick(R.id.dzielenie)
    public void show4(){
        String wynik1 = liczbaPierwsza.getText().toString();
        int przeliczonaWartoscLiczbaPierwsza = Integer.parseInt(wynik1);
        String wynik2 = liczbaPierwsza.getText().toString();
        int przeliczonaWartoscLiczbaDruga = Integer.parseInt(wynik2);
        calculator.podziel(przeliczonaWartoscLiczbaPierwsza, przeliczonaWartoscLiczbaDruga);
        wynikDisplay.setText(String.valueOf(calculator));

    }
}
