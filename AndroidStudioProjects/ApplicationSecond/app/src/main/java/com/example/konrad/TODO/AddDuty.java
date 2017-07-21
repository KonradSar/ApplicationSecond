package com.example.konrad.TODO;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.konrad.applicationsecond.AddProduct;
import com.example.konrad.applicationsecond.NaszeMetody;
import com.example.konrad.applicationsecond.R;
import com.example.konrad.applicationsecond.ShopRecyclerView;
import com.example.konrad.applicationsecond.Shopping;
import com.example.konrad.TODO.DataBaseQueries2;
import com.example.konrad.daneSQL.DataBaseQueries;
import com.example.konrad.daneSQL.Movies;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.id.content;
//import static com.example.konrad.applicationsecond.R.id.terminWykonania;

public class AddDuty extends AppCompatActivity {
    final String TAG = "KonradApp";
    @BindView(R.id.wydarzenie)
    EditText opisWydarzenia;
    @BindView(R.id.btnAddToList)
    Button btnDodajDoListy;
    @BindView(R.id.date2)
    EditText dateView;
    @BindView(R.id.btnGoToList) Button btnGoToList;

    Calendar calendar = Calendar.getInstance();
    DataBaseQueries2 dataBaseQueries2;
    DataBaseQueries2 polaczenieBazy;


    @OnClick(R.id.btnAddToList)
    public void dodajDoBazy2() {
         polaczenieBazy.dodajDoBazy2(opisWydarzenia.getText().toString(), dateView.getText().toString());

    }
    @OnClick(R.id.btnGoToList)
    public void wyswietlDane(){
        Intent intent = new Intent(AddDuty.this, DutiesRecyclerView.class);
        startActivity(intent);




    }
    public void updateDateLabel(EditText editText) {
        String dataFormat = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataFormat, Locale.UK);
        editText.setText(simpleDateFormat.format(calendar.getTime()));

    }

    @OnClick(R.id.date2)
    public void addToDatabase() {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_duty);
        polaczenieBazy = new DataBaseQueries2(this);
        polaczenieBazy.otworzZapis();
        ButterKnife.bind(this);
        dateView.setFocusable(false);
        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddDuty.this, date, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateDateLabel(dateView);
                }
            };
        });
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateDateLabel(dateView);

    }
}
