package com.example.konrad.TODO;

import android.provider.BaseColumns;

/**
 * Created by Konrad on 06.07.2017.
 */

public final class DutiesContract {
    private DutiesContract(){}

    public static class DutiesTable implements BaseColumns{
        public static final String NAZWA_TABELI = "obowiazki";
        public static final String KOLUMNA_OPIS_WYDARZENIA = "opisZdarzenia";
        public static final String KOLUMNA_TERMIN_WYKONANIA = "terminWykonania";

    }
}
