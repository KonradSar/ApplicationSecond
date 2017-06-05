package com.example.konrad.applicationsecond;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RejestracjaActivity extends AppCompatActivity {

    @BindView(R.id.btnName) EditText name;
    @BindView(R.id.btnSurname) EditText surname;
    @BindView(R.id.btnPostCode) EditText postOffice;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        ButterKnife.bind(this);



    }
}
