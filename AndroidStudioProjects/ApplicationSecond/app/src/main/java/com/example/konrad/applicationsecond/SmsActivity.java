package com.example.konrad.applicationsecond;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;

public class SmsActivity extends AppCompatActivity {
    final int MY_PERMISSIONS_REQUEST_WRITE_SMS = 1;
    public static final String TAG = "DarekApp";

    EditText enterPnoneNumber;
    EditText enterMEssage;
    Button sendMessageButton;
    Button getPermissionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        enterPnoneNumber = (EditText) findViewById(R.id.editText);
        enterMEssage = (EditText) findViewById(R.id.editText2);
        sendMessageButton = (Button) findViewById(R.id.button);
        getPermissionButton = (Button) findViewById(R.id.button2);
        sendMessageButton.setOnClickListener(onSMSClick);
        getPermissionButton.setOnClickListener(onDostepClick);

    }

    public View.OnClickListener onSMSClick = new View.OnClickListener(){
        public void onClick(View v){
            // z Edittext za pomoca funkcji getText().toString() wykonanej na kontrolce pobieramy wpisany tekst
            // sendsms to wlasna funkcja do wysylania smsow opisana ponizej
            sendSms(enterPnoneNumber.getText().toString(), enterMEssage.getText().toString());
        }
    };

    // wlasna funkcja ktora przyjmuje numer telefonu i tresc wiadomosci
    private void sendSms(String phoneNo, String msg) {
        try {
            //wykorzystujemy smsmanager czyli wbudowane api do zarzadzania smsami
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);

            // za pomoca Log mozemy zrobic log momencie wyslania SMS . Ten log jest widoczny w ANdroid Monitorze.
            Log.d(TAG, "SMS Wysłany");

            // ponizej na dwa sposoby czyscimy wpisane kontrolki
            enterPnoneNumber.setText("");
            enterMEssage.getText().clear();
        } catch (Exception ex) {
            Log.d(TAG, "SMS Nie wysłany");
            ex.printStackTrace();
        }
    }
    public View.OnClickListener onDostepClick = new View.OnClickListener(){
        @RequiresApi(api = Build.VERSION_CODES.M)
        public void onClick(View v){

            // sprawdzamy czy jest przyznay dostep
            if(android.support.v4.app.ActivityCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED){

                // za pomoca tej funkcji sprawdzamy czy uzytkownik po raz pierwszy juz blokowal dostep do sms
                if (ActivityCompat.shouldShowRequestPermissionRationale(SmsActivity.this,
                        Manifest.permission.SEND_SMS)){
                    // jesli dostep blokowal pokazujemy po co nam to potrzebne
//                    showExplanation("Potrzebujemy pozwolenia", "Chcemy wysłać SMS który napisałeś, więc potrzebujemy pozwolenia",
//                            Manifest.permission.SEND_SMS, MY_PERMISSIONS_REQUEST_WRITE_SMS);
                }else{
                    // pokazujemy okienko z prosba za pierwszym razem odrazu systemowe
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_WRITE_SMS);
                }
            }else{
                // wlaczamy przycisk sms jesli dostep przyznay ( mozna to sprawdzac z automatu w oncreate aby za kazdym razem nie sprawdzac tutaj)
                getPermissionButton.setEnabled(true);
            }
        }
    };



}
