package com.example.konrad.applicationsecond;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import butterknife.BindView;
import butterknife.OnClick;


public class MojeKontoActivity extends AppCompatActivity {
    final String TAG = "KonradApp";
    @BindView(R.id.btnCountAge) Button obliczWiekbtn;
    @BindView(R.id.btnAge) EditText wprowadzonyWiek;

    @OnClick(R.id.btnCountAge)
    public void count(){
        String wiek = wprowadzonyWiek.getText().toString();
        int przeliczonyWiek = Integer.parseInt(wiek);
        int wynik = 2017 - przeliczonyWiek;
        Toast.makeText(getApplicationContext(), wynik, Toast.LENGTH_SHORT).show();
        Log.d(TAG, wiek);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        ActivityMojeKontoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_moje_konto);
//        String imie = getIntent().getStringExtra("przekazuje_imie");
//        String nazwisko = getIntent().getStringExtra("przekazuje_nazwisko");
//        Boolean matDodatkowe = getIntent().getBooleanExtra("materialy_dodatkowe", false);
//        Uzytkownik newGosc = new Uzytkownik(imie, nazwisko, matDodatkowe);
//        binding.setUzytkownik(newGosc);


    }
}
