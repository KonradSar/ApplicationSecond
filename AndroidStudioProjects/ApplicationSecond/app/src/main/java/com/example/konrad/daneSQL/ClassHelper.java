package com.example.konrad.daneSQL;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Konrad on 04.07.2017.
 */

public class ClassHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "KursBaza.db";
    public static final String DELETETABLE = "DROP TABLE IF EXISTS "+ MoviesContract.MoviesTable.NAZWA_TABELI;

    /** CREATE TABLE Film (film_id integer primary key, tytul text, budzet integer, rokPowstania text);
     * **/
    public static final String CREATESQLQUERY = "CREATE TABLE " + MoviesContract.MoviesTable.NAZWA_TABELI + " (" + MoviesContract.MoviesTable._ID +
            " INTEGER PRIMARY KEY," + MoviesContract.MoviesTable.KOLUMNA_TYTUL + " TEXT," + MoviesContract.MoviesTable.KOLUMNA_BUDZET + " INTEGER," +
            MoviesContract.MoviesTable.KOLUMNA_ROK_POWSTANIA + " TEXT)";


    public ClassHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATESQLQUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETETABLE);
        onCreate(db);

    }
}
