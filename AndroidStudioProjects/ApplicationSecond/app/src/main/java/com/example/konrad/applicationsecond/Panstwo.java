package com.example.konrad.applicationsecond;

/**
 * Created by Konrad on 14.06.2017.
 */

public class Panstwo {
    int flaga;
    String stolica;
    String nazwaPanstwa;

    public Panstwo(int flaga, String stolica, String nazwaPanstwa) {
        this.flaga = flaga;
        this.stolica = stolica;
        this.nazwaPanstwa = nazwaPanstwa;
    }

    public int getFlaga() {
        return flaga;
    }

    public String getStolica() {
        return stolica;
    }

    public String getNazwaPanstwa() {
        return nazwaPanstwa;
    }

    public void setFlaga(int flaga) {
        this.flaga = flaga;
    }

    public void setStolica(String stolica) {
        this.stolica = stolica;
    }

    public void setNazwaPanstwa(String nazwaPanstwa) {
        this.nazwaPanstwa = nazwaPanstwa;
    }
}
