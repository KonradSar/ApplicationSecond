package com.example.konrad.TODO;

/**
 * Created by Konrad on 06.07.2017.
 */

public class Duties {
    public int Id;
    public String opisZdarzenia;
    public String terminWykonania;

    public String zwrocOpisWydarzenia(){
        return opisZdarzenia;
    }
    public String zwrocTerminWykonania(){
        return terminWykonania;
    }


    public Duties(String opisZdarzenia, String terminWykonania) {
        this.opisZdarzenia = opisZdarzenia;
        this.terminWykonania = terminWykonania;
    }

    public Duties(int id, String opisZdarzenia, String terminWykonania) {
        Id = id;
        this.opisZdarzenia = opisZdarzenia;
        this.terminWykonania = terminWykonania;
    }

    public Duties() {

    }

    public Duties(String opisZdarzenia) {
        this.opisZdarzenia = opisZdarzenia;
    }

    public String zwrocWiersz(){
        return Id + " ," + opisZdarzenia;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getOpisZdarzenia() {
        return opisZdarzenia;
    }

    public void setOpisZdarzenia(String opisZdarzenia) {
        this.opisZdarzenia = opisZdarzenia;
    }

    public String getTerminWykonania() {
        return terminWykonania;
    }

    public void setTerminWykonania(String terminWykonania) {
        this.terminWykonania = terminWykonania;
    }
}
