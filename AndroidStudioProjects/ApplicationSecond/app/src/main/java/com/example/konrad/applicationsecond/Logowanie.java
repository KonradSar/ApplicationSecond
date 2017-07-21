package com.example.konrad.applicationsecond;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.konrad.applicationsecond.R.id.editText5;

public class Logowanie extends AppCompatActivity {
    final String TAG = "KonradApp";
    @BindView(editText5) EditText editone;
    @BindView(R.id.editText6) EditText editsecond;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);
        ButterKnife.bind(this);
    }
//    SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
//    SharedPreferences.Editor editor = sharedPreferences.edit();
//    editor.putString("login", editone.getText().toString());
//    editor.apply();
     //natomiast w innym layoucie:
//    SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
//    String login = sharedPreferences.getString(, "");
//    etlogin.setText(login);

}
