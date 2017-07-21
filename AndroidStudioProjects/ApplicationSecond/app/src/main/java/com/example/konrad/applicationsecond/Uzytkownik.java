package com.example.konrad.applicationsecond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class Uzytkownik implements Serializable {
    public String imie;
    public String nazwisko;
    public boolean matDodatkowe;

    public Uzytkownik(String imie, String nazwisko, boolean matDodatkowe){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.matDodatkowe = matDodatkowe;
    }


}
