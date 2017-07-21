package com.example.konrad.applicationsecond;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class Weatherapi extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_INTERNET = 1;
    final String TAG = "KonradApp";

    @BindView(R.id.cityEditText)
    EditText cityField;
    @BindView(R.id.temperatureView)
    TextView tempView;
    @BindView(R.id.selectBtn)
    Button selectCity;
    @BindView(R.id.secondText) TextView secondTextView;
    @BindView(R.id.pressureView) TextView pressureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.selectBtn)
    public void checkTemp() {
        String name = cityField.getText().toString();
        AsyncTask<Void, Void, WeatherResults> execute = new Weather(name).execute();
        try {
            WeatherResults weatherResults = execute.get();
            tempView.setText("Aktualna temperatura w mieście " + name + " wynosi: " + weatherResults.getTemperature() + " st Celsjusza");
            secondTextView.setText("Sila wiatru: "+ weatherResults.getWindSpeed());
            pressureView.setText("Cisnienie wynosi " + weatherResults.getPressure());


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}







