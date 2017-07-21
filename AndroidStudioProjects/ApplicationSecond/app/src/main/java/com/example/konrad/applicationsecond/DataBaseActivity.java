package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.konrad.daneSQL.DataBaseQueries;
import com.example.konrad.daneSQL.Movies;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataBaseActivity extends AppCompatActivity {
    DataBaseQueries polaczenieBazy;

    @BindView(R.id.textView1111) TextView display;

    @OnClick(R.id.dodaj)
    public void dodajDoBazy(){
        String zwrotIdWprowadzonego = polaczenieBazy.dodajDoBazy("StatWars", 130000, "1977-05-25");
        display.setText(zwrotIdWprowadzonego);


    }
    @OnClick(R.id.wyswietl)
    public void wyswietlRekordy(){
        List<Movies> lista = polaczenieBazy.zwrocListeFilmow();
        String text = "";
        for (Movies item : lista){
            text = text + item.zwrocWiersz() + "<br/>";
        }
        display.setText(NaszeMetody.fromHtml(text));
    }
    @OnClick(R.id.usun)
    public void usun(){
        polaczenieBazy.usun("0");
        polaczenieBazy.usun("1");
        polaczenieBazy.usun("3");
        polaczenieBazy.usun("4");
        polaczenieBazy.usun("5");
        wyswietlRekordy();
    }
    @OnClick(R.id.edytuj)
    public void edytujWiersz(){
        polaczenieBazy.edytujWiersz("2", 100);
        wyswietlRekordy();
    }

    @OnClick(R.id.czysc)
    public void czscicielBazy(){

        polaczenieBazy.czyscicielBazy();;
        wyswietlRekordy();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        polaczenieBazy = new DataBaseQueries(this);
        polaczenieBazy.otworzZapis();
        ButterKnife.bind(this);
    }
    @Override
    protected void onDestroy(){
        polaczenieBazy.zamknij();
        super.onDestroy();
    }
}
