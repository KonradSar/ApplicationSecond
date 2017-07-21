package com.example.konrad.daneSQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 04.07.2017.
 */

public class DataBaseQueries {
    private SQLiteDatabase baza;
    private ClassHelper pomocnikBazy;
    public DataBaseQueries(Context context){
        pomocnikBazy = new ClassHelper(context);
    }
    public void otworzZapis() throws SQLException{
        baza = pomocnikBazy.getWritableDatabase();
    }
    public void otworzOdczyt(){
        baza = pomocnikBazy.getReadableDatabase();
    }
    public void zamknij(){
        baza.close();
    }
    public String dodajDoBazy(String nazwaFilmu, int budzet, String rokpowstania){
        ContentValues wartosci = new ContentValues();
        wartosci.put(MoviesContract.MoviesTable.KOLUMNA_TYTUL, nazwaFilmu);
        wartosci.put(MoviesContract.MoviesTable.KOLUMNA_BUDZET, budzet);
        wartosci.put(MoviesContract.MoviesTable.KOLUMNA_ROK_POWSTANIA, rokpowstania);

        long numerWiersza = baza.insert(MoviesContract.MoviesTable.NAZWA_TABELI, null, wartosci);
        return String.valueOf(numerWiersza);
    }
    public List<Movies> zwrocListeFilmow(){
        ArrayList<Movies> listaFilmow = new ArrayList<Movies>();
        Cursor cursor = baza.query(MoviesContract.MoviesTable.NAZWA_TABELI, null, null, null, null, null, null);
        Movies movies;
        if(cursor.getCount() > 0){
            for (int i = 0; i < cursor.getCount(); i++){
                cursor.moveToNext();
                movies = new Movies();
                movies.setId(cursor.getInt(0));
                movies.setTytul(cursor.getString(1));
                movies.setBudzet(cursor.getInt(2));
                movies.setStringrokPowstania(cursor.getString(3));
                listaFilmow.add(movies);

            }
        }
        return listaFilmow;
    }
    public void usun(String id){
        String selection = MoviesContract.MoviesTable._ID + " = ?";
        String selectionArgumenty[] = { id };
        baza.delete(MoviesContract.MoviesTable.NAZWA_TABELI, selection, selectionArgumenty);
    }
    public void edytujWiersz(String id, int budzet){
        ContentValues wartosci = new ContentValues();
        wartosci.put(MoviesContract.MoviesTable.KOLUMNA_BUDZET, budzet);
        String selection = MoviesContract.MoviesTable._ID + " =?";
        String selectionArgumenty[] = { id };
        baza.update(MoviesContract.MoviesTable.NAZWA_TABELI, wartosci, selection, selectionArgumenty);

    }
    public void czyscicielBazy(){
        baza.execSQL("DELETE FROM " + MoviesContract.MoviesTable.NAZWA_TABELI);
        // Ponizej raw gdy uzywamy select i zwraca to kursor
//        baza.rawQuery("DELETE FROM "+ MoviesContract.MoviesTable.NAZWA_TABELI, null);
    }
}
