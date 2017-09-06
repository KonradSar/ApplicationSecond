package com.example.konrad.aplikacjadotestow;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by Konrad on 05.08.2017.
 */
public class CalculatorTest {
    Calculator calculator;
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();

    }

    @After
    public void tearDown() throws Exception {
        calculator = null;

    }
    @Test
    public void testujDodawaj(){
        assertEquals(7, calculator.dodawaj(3,4));

    }
    @Test
    public void testujODejmowanie(){
        assertEquals(2, calculator.odejmij(7, 5));
    }
    @Test
    public void testujMnozenie(){
        assertEquals(25, calculator.pomnoz(5, 5));
    }
    @Test
    public void testujDzielenie(){
        assertEquals((Object) 2.0, (Object) calculator.podziel(10, 5));
    }

}