package com.example.konrad.daneSQL;

import android.provider.BaseColumns;

/**
 * Created by Konrad on 04.07.2017.
 */

public final class MoviesContract {
    private MoviesContract(){}

    public static class MoviesTable implements BaseColumns{
        public static final String NAZWA_TABELI = "film";
        public static final String KOLUMNA_TYTUL = "tytul";
        public static final String KOLUMNA_BUDZET = "budzet";
        public static final String KOLUMNA_ROK_POWSTANIA = "rokpowstania";

    }
    }

