package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;


public class MojGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.example.konrad.db");
        schema.enableKeepSectionsByDefault();
        AddTables(schema);
            try {
                new DaoGenerator().generateAll(schema, "./app/src/main/java");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    // ta funkcja dodaje schematy tabelek do bazy danych
    private static void AddTables(Schema schema){
        addProduktEntity(schema);
        addZamowieniaEntity(schema);
    }
    // schemat tabelki produkt
    private static Entity addProduktEntity(final Schema schema){
        Entity produkt = schema.addEntity("Produkt");
        produkt.addIdProperty().primaryKey().autoincrement();
        produkt.addStringProperty("nazwa");
        produkt.addFloatProperty("cena");
        return produkt;
    }
    // schemat tabelki produkty
    private static Entity addZamowieniaEntity(final Schema schema){
        Entity zamowienia = schema.addEntity("Zamowienia");
        zamowienia.addIdProperty().primaryKey().autoincrement();
        zamowienia.addStringProperty("Produkt");
        zamowienia.addFloatProperty("suma");
        zamowienia.addDateProperty("data");
        return zamowienia;
    }
}
