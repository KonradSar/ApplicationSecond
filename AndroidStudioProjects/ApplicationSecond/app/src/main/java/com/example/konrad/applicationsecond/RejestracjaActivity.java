package com.example.konrad.applicationsecond;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RejestracjaActivity extends AppCompatActivity {
    final String TAG = "KonradApp";

    @BindView(R.id.btnName) EditText name;
    @BindView(R.id.btnSurname) EditText surname;
    @BindView(R.id.btnPostCode) EditText postOffice;
    @BindView(R.id.btnRegister) Button rejestracja;
    @BindView(R.id.btnSwitch) Switch akceptuj;



    @OnClick(R.id.btnRegister)
    public void show(){
        boolean czyZaznaczylMaterialyDodatkowe = akceptuj.isChecked();
        Intent i = new Intent(RejestracjaActivity.this, MojeKontoActivity.class);
        i.putExtra("przekazuje_imie", name.getText().toString());
        i.putExtra("przekazuje_nazwisko", surname.getText().toString());
        i.putExtra("materialy_dodatkowe", czyZaznaczylMaterialyDodatkowe);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        ButterKnife.bind(this);
    }
}
