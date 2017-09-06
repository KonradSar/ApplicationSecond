package com.example.konrad.aplikacjadotestow;

/**
 * Created by Konrad on 05.08.2017.
 */

public class Calculator {
    public int dodawaj(int a, int b){
        return a+b;
    }
    public int odejmij(int a, int b){
        return a-b;
    }
    public int pomnoz(int a, int b){
        return a*b;
    }
    public double podziel(int a, int b){
        double wynik = (double) a/b;
        return wynik;
    }
}
