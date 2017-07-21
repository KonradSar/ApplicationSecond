package com.example.konrad.daneSQL;

/**
 * Created by Konrad on 05.07.2017.
 */

public class Movies {
    private int Id;
    private String tytul;
    private int budzet;
    private String StringrokPowstania;
    public String zwrocWiersz(){
        return tytul + " ," + budzet + " ," + StringrokPowstania;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getBudzet() {
        return budzet;
    }

    public void setBudzet(int budzet) {
        this.budzet = budzet;
    }

    public String getStringrokPowstania() {
        return StringrokPowstania;
    }

    public void setStringrokPowstania(String stringrokPowstania) {
        StringrokPowstania = stringrokPowstania;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
