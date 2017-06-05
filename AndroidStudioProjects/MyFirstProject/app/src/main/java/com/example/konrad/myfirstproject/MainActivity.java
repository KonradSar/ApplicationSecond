package com.example.konrad.myfirstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final String TAG = "KonradApp";
    String wpisanyTekst;
    EditText wpisanyAdresUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity: onCreate()");
        wpisanyAdresUrl = (EditText) findViewById(R.id.editText);
        Button Go = (Button) findViewById(R.id.button);

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wpisanyTekst = wpisanyAdresUrl.getText().toString();
                Log.d(TAG, wpisanyTekst);
                Intent i = new Intent(MainActivity.this, DrugieActivity.class);
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
        // aktywnosc w trakcie powracania na ekran
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart()");
        // aktywnosc przed ukazaniem sie na ekranie
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume()");
        // aktywnosc jest juz na ekranie
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
        //aktywnosc przed przyslonieciem przez inna aktywnosc
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
        // aktywnosc nie jest juz widoczna
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
        // aktywnosc przed usunieciem z pamieci
    }
}
