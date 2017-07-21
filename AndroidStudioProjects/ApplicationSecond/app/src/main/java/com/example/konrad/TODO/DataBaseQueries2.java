package com.example.konrad.TODO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;



import com.example.konrad.daneSQL.Movies;
import com.example.konrad.daneSQL.MoviesContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 06.07.2017.
 */

public class DataBaseQueries2 {
    private SQLiteDatabase baza;
    private ClassHelper2 pomocnikBazy;
    public DataBaseQueries2(Context context){
        pomocnikBazy = new ClassHelper2(context);
    }
    public void otworzZapis() throws SQLException {
        baza = pomocnikBazy.getWritableDatabase();
    }
    public void otworzOdczyt(){
        baza = pomocnikBazy.getReadableDatabase();
    }
    public void zamknij(){
        baza.close();
    }
    public void dodajDoBazy2(String opisWydarzenia, String terminWykonania){
        ContentValues wartosci = new ContentValues();
        wartosci.put(DutiesContract.DutiesTable.KOLUMNA_OPIS_WYDARZENIA, opisWydarzenia);
        wartosci.put(DutiesContract.DutiesTable.KOLUMNA_TERMIN_WYKONANIA, terminWykonania);
        baza.insert(DutiesContract.DutiesTable.NAZWA_TABELI, null, wartosci);
    }
    public ArrayList<Duties> zwrocListeFilmow(){
        ArrayList<Duties> listaCzynnosci = new ArrayList<Duties>();
        Cursor cursor = baza.query(DutiesContract.DutiesTable.NAZWA_TABELI, null, null, null, null, null, null);
        Duties duties;
        if(cursor.getCount() > 0){
            for (int i = 0; i < cursor.getCount(); i++){
                cursor.moveToNext();
                duties = new Duties();
                duties.setOpisZdarzenia(cursor.getString(0));
                duties.setTerminWykonania(cursor.getString(1));
                listaCzynnosci.add(duties);
            }
        }
        return listaCzynnosci;
    }
    public void usun(String id){
        String selection = DutiesContract.DutiesTable._ID + " = ?";
        String selectionArgumenty[] = { id };
        baza.delete(DutiesContract.DutiesTable.NAZWA_TABELI, selection, selectionArgumenty);
    }
    public void edytujWiersz(String id, String opisWydarzenia, String terminWykonania){
        ContentValues wartosci = new ContentValues();
        wartosci.put(DutiesContract.DutiesTable.KOLUMNA_OPIS_WYDARZENIA, opisWydarzenia);
        wartosci.put(DutiesContract.DutiesTable.KOLUMNA_TERMIN_WYKONANIA, terminWykonania);
        String selection = MoviesContract.MoviesTable._ID + " =?";
        String selectionArgumenty[] = { id };
        baza.update(DutiesContract.DutiesTable.NAZWA_TABELI, wartosci, selection, selectionArgumenty);

    }
    public void czyscicielBazy(){
        baza.execSQL("DELETE FROM " + DutiesContract.DutiesTable.NAZWA_TABELI);
        // Ponizej raw gdy uzywamy select i zwraca to kursor
//        baza.rawQuery("DELETE FROM "+ MoviesContract.MoviesTable.NAZWA_TABELI, null);
    }
}
